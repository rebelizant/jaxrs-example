package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Order;
import io.github.rebelizant.jaxrsexample.persistence.CustomerRepository;
import io.github.rebelizant.jaxrsexample.persistence.OrderRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Named
@Singleton
public class OrderSubResourceImpl implements OrderSubResource {

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private CustomerRepository customerRepository;

    public OrderSubResourceImpl() {
    }

    @Override
    public Order submitOrder(Long customerId, Order order) {
        order.setCustomer(customerRepository.getCustomer(customerId));
        Long orderId = orderRepository.addOrder(order);
        return orderRepository.getOrder(orderId);
    }

    @Override
    public Order getOrder(Long customerId, Long orderId) {
        return orderRepository.getOrder(customerId, orderId);
    }

    @Override
    public List<Order> getOrders(Long customerId, int start, int count) {
        return orderRepository.getOrdersByCustomer(customerId, start, count);
    }

}