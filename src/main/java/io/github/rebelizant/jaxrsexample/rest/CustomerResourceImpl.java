package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Customer;
import io.github.rebelizant.jaxrsexample.persistence.CustomerRepository;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Component
@Singleton
public class CustomerResourceImpl implements CustomerResource {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private OrderSubResource orderSubResource;

    public CustomerResourceImpl() {
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> getCustomers(int start, int size) {
        return customerRepository.getCustomers(start, size);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        customerRepository.updateCustomer(id, customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public OrderSubResource getOrderSubResource() {
        return orderSubResource;
    }
}
