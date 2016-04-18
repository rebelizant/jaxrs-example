package io.github.rebelizant.jaxrsexample.domain;

import java.math.BigDecimal;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
public class Product extends AbstractEntity {

    private String name;

    private BigDecimal cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
