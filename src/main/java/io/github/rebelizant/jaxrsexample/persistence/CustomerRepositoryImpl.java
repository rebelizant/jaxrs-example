package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.Address;
import io.github.rebelizant.jaxrsexample.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    private ConcurrentMap<Long, Customer> customers = new ConcurrentHashMap<>();

    public CustomerRepositoryImpl() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("John");
        customer.setLastName("Konstantine");
        Address address = new Address();
        address.setCountry("UK");
        address.setCity("London");
        customer.setAddress(address);
        addCustomer(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customers.values().stream().collect(Collectors.toList());
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
