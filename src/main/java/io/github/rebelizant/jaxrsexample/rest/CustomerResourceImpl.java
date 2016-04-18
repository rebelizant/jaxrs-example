package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Customer;
import io.github.rebelizant.jaxrsexample.persistence.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.PathParam;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Named
public class CustomerResourceImpl implements CustomerResource {

    @Inject
    private CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public void updateCustomer(@PathParam("id") Long id, Customer customer) {
        customerRepository.updateCustomer(id, customer);
    }

    @Override
    public Customer getCustomer(@PathParam("id") Long id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public void deleteCustomer(@PathParam("id") Long id) {
        customerRepository.deleteCustomer(id);
    }
}
