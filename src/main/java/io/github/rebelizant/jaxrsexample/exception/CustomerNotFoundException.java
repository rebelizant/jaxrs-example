package io.github.rebelizant.jaxrsexample.exception;

/**
 * @author rebelizant
 *         Created on 08.05.16
 */
public class CustomerNotFoundException extends JaxRsExampleException {
    public CustomerNotFoundException(Long id) {
        super(String.format("Customer not found: customerId=%s", id));
    }
}
