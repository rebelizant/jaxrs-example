package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.*;

import java.util.List;

public interface OrderRepository extends Repository<Order> {
    
    void addOrder(Order order);
    
    List<Order> getAllOrders();
    
    List<Order> getOrdersByCustomer(Long customerId, int start, int count);
    
    void updateOrder(Long orderId, Order order);
    
    Order getOrder(Long orderId);

    Order getOrder(Long customerId, Long orderId);
    
    void deleteOrder(Long orderId);
    
}