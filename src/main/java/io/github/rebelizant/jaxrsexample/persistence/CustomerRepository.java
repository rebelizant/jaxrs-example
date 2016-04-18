package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.Customer;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
public interface CustomerRepository {

    void addCustomer(Customer customer);

    void updateCustomer(Long id, Customer customer);

    Customer getCustomer(Long id);

    void deleteCustomer(Long id);

}
