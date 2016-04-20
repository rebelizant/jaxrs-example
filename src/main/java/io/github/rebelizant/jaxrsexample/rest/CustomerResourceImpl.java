package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Customer;
import io.github.rebelizant.jaxrsexample.persistence.CustomerRepository;
import io.github.rebelizant.jaxrsexample.persistence.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Component
public class CustomerResourceImpl implements CustomerResource {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResourceImpl() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
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
}
