package io.github.rebelizant.jaxrsexample.exception;

/**
 * @author rebelizant
 *         Created on 08.05.16
 */
public class OrderNotFoundException extends JaxRsExampleException {

    public OrderNotFoundException(Long customerId, Long orderId) {
        super(String.format("Order hasn't been found, customerId=%s, orderId=%s", customerId, orderId));
    }
}
