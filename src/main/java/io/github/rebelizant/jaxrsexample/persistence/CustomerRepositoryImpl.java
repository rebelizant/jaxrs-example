package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.Customer;

import javax.inject.Named;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Named
public class CustomerRepositoryImpl implements CustomerRepository {

    private ConcurrentMap<Long, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customers.get(id);
    }

    @Override
    public void deleteCustomer(Long id) {
        customers.remove(id);
    }
}
