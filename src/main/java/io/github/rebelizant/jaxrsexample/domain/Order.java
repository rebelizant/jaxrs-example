package io.github.rebelizant.jaxrsexample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Order extends AbstractEntity {

    private Date date;

    private Customer customer;

    private List<OrderItem> orderItems = new ArrayList<>();

    public void addItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        removeItem(orderItem);
    }

    public BigDecimal getTotalCost() {
        return orderItems.stream()
                    .map(OrderItem::getTotalCost)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
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
