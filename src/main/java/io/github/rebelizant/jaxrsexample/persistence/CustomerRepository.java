package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.Customer;

import java.util.List;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
public interface CustomerRepository {

    void addCustomer(Customer customer);

    List<Customer> getCustomers();

    void updateCustomer(Long id, Customer customer);

    Customer getCustomer(Long id);

    void deleteCustomer(Long id);

}
