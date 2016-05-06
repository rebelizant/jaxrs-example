package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.Customer;

import java.util.List;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
public interface CustomerRepository extends Repository<Customer> {

    void addCustomer(Customer customer);

    List<Customer> getCustomers(int start, int size);

    void updateCustomer(Long id, Customer customer);

    Customer getCustomer(Long id);

    void deleteCustomer(Long id);

}
