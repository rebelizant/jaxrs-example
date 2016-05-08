package io.github.rebelizant.jaxrsexample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderItem {

    private int quantity;

    private Product product;

    private transient BigDecimal cost;

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

    @JsonProperty
    public BigDecimal getCost() {
        return BigDecimal.ZERO.equals(cost) || cost == null ? product.getCost() : cost;
    }

    @JsonIgnore
    public BigDecimal getTotalCost() {
        return BigDecimal.valueOf(quantity).multiply(getCost());
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
