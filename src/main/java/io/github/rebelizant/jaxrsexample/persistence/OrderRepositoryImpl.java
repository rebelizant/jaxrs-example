package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.AbstractEntity;
import io.github.rebelizant.jaxrsexample.domain.Order;
import io.github.rebelizant.jaxrsexample.domain.OrderItem;
import io.github.rebelizant.jaxrsexample.exception.OrderNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    
    private ConcurrentMap<Long, Order> orders;

    @Inject
    private ProductRepository productRepository;

    @Inject
    private CustomerRepository customerRepository;
    
    public OrderRepositoryImpl() {
    }
    
    @PostConstruct
    public void init() {
        orders = IntStream.range(1, 41).mapToObj(this::randomOrder)
                        .collect(Collectors.toConcurrentMap(AbstractEntity::getId, o -> o));
    }
    
    @Override
    public void addOrder(Order order) {
        Long nextId = nextId(orders);
        order.setId(nextId);
        orders.putIfAbsent(nextId, order);
    }
    
    @Override
    public List<Order> getAllOrders() {
        return orders.values().stream().collect(Collectors.toList());
    }
    
    @Override
    public List<Order> getOrdersByCustomer(Long customerId, int start, int count) {
        Stream<Order> orderStream = orders.values().stream()
                .filter(o -> o.getCustomer().getId().equals(customerId))
                .skip(start > 0 ? start - 1 : 0);
        if (count > 0) {
            return orderStream.limit(count).collect(Collectors.toList());
        }
        return orderStream.collect(Collectors.toList());
    }
    
    @Override
    public void updateOrder(Long orderId, Order order) {
        if (orders.get(orderId) == null) {
            throw new OrderNotFoundException(orderId);
        }
        order.setId(orderId);
        orders.put(orderId, order);
    }
    
    @Override
    public Order getOrder(Long orderId) {
        return Optional.ofNullable(orders.get(orderId))
                .orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    @Override
    public Order getOrder(Long customerId, Long orderId) {
        return orders.values().stream().filter(o -> o.getCustomer().getId().equals(customerId))
                .filter(o -> o.getId().equals(orderId)).findFirst().
                orElseThrow(() -> new OrderNotFoundException(customerId, orderId));
    }

    @Override
    public void deleteOrder(Long orderId) {
        if (orders.remove(orderId) == null) {
            throw new OrderNotFoundException(orderId);
        }
    }
    
    private Order randomOrder(int id) {
        Order order = new Order();
        order.setId((long) id);
        List<OrderItem> orderItems = IntStream.range(1, id % 10 + 2).mapToObj(this::randomOrderItem).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        order.setCustomer(customerRepository.getCustomer((long) (id % 20 + 1)));
        return order;
    }
    
    private OrderItem randomOrderItem(int id) {
        OrderItem orderItem = new OrderItem();
        if (Math.random() > 0.9) {
            orderItem.setCost(BigDecimal.valueOf(Math.random() * 10).setScale(2, BigDecimal.ROUND_HALF_UP));
        }
        orderItem.setQuantity(Math.random() > 0.5 ? 2 : 1);
        orderItem.setProduct(productRepository.getProduct((long) id));
        return orderItem;
    }
    
}