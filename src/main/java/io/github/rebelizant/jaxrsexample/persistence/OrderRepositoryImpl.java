package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.*;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

import java.util.stream.IntStream;
import java.util.stream.Collectors;

import java.math.BigDecimal;

@Component
public class OrderRepositoryImpl implements OrderRepository {
    
    private ConcurrentMap<Long, Order> orders;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private CustomerRepository customerRepository;
    
    public OrderRepositoryImpl() {
    }
    
    @PostConstruct
    public void init() {
        orders = IntStream.range(1, 41).mapToObj(id -> randomOrder(id))
                        .collect(Collectors.toConcurrentMap(o -> o.getId(), o -> o));
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
    public List<Order> getOrdersByCustomer(Long customerId) {
        return orders.values().stream()
            .filter(o -> o.getCustomer().getId().equals(customerId))
            .collect(Collectors.toList());
    }
    
    @Override
    public void updateOrder(Long orderId, Order order) {
        order.setId(orderId);
        orders.put(orderId, order);
    }
    
    @Override
    public Order getOrder(Long orderId) {
        return orders.get(orderId);
    }
    
    @Override
    public void deleteOrder(Long orderId) {
        orders.remove(orderId);
    }
    
    private Order randomOrder(int id) {
        Order order = new Order();
        order.setId(Long.valueOf(id));
        List<OrderItem> orderItems = IntStream.range(1, id % 10 + 1).mapToObj(i -> randomOrderItem(i)).collect(Collectors.toList());
        order.setOrderItems(orderItems);
        order.setCustomer(customerRepository.getCustomer(Long.valueOf(id % 20 + 1)));
        return order;
    }
    
    private OrderItem randomOrderItem(int id) {
        OrderItem orderItem = new OrderItem();
        if (Math.random() > 0.9) {
            orderItem.setCost(BigDecimal.valueOf(Math.random() * 10));
        }
        orderItem.setQuantity(Math.random() > 0.5 ? 2 : 1);
        orderItem.setProduct(productRepository.getProduct(Long.valueOf(id)));
        return orderItem;
    }
    
}