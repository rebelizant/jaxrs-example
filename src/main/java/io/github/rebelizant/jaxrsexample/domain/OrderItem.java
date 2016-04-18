package io.github.rebelizant.jaxrsexample.domain;

import java.math.BigDecimal;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
public class OrderItem extends AbstractEntity {

    private int quantity;

    private Product product;

    private BigDecimal cost;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
