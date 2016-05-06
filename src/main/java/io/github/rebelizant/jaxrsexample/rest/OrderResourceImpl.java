package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.*;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.rebelizant.jaxrsexample.persistence.OrderRepository;
import io.github.rebelizant.jaxrsexample.persistence.OrderRepositoryImpl;

import javax.inject.Singleton;

@Component
@Singleton
public class OrderResourceImpl implements OrderResource {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public OrderResourceImpl() {
    }
    
    @Override
    public Order getOrder(Long id) {
        return orderRepository.getOrder(id);
    }
    
}