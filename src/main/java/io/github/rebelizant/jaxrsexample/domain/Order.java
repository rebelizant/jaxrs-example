package io.github.rebelizant.jaxrsexample.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
public class Order extends AbstractEntity {

    private BigDecimal totalCost;

    private Date date;

    private Customer customer;

    private List<OrderItem> orderItems = new ArrayList<>();

    public void addItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        removeItem(orderItem.getId());
    }

    public void removeItem(Long orderItemId) {
        orderItems.stream()
                .filter(self -> Objects.equals(self.getId(), orderItemId))
                .findFirst()
                .ifPresent(self -> orderItems.remove(self));
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
