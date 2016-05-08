package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Order;
import io.github.rebelizant.jaxrsexample.persistence.OrderRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Component
@Singleton
public class OrderSubResourceImpl implements OrderSubResource {

    @Inject
    private OrderRepository orderRepository;
    
    public OrderSubResourceImpl() {
    }
    
    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.getOrder(orderId);
    }

    @Override
    public List<Order> getOrders(Long customerId, int start, int count) {
        return orderRepository.getOrdersByCustomer(customerId, start, count);
    }

}