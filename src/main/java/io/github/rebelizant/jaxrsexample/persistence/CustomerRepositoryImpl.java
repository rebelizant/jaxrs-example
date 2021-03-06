package io.github.rebelizant.jaxrsexample.persistence;

import io.github.rebelizant.jaxrsexample.domain.AbstractEntity;
import io.github.rebelizant.jaxrsexample.domain.Address;
import io.github.rebelizant.jaxrsexample.domain.Customer;
import io.github.rebelizant.jaxrsexample.exception.CustomerNotFoundException;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Named
public class CustomerRepositoryImpl implements CustomerRepository {

    private ConcurrentMap<Long, Customer> customers;

    public CustomerRepositoryImpl() {
    }

    @PostConstruct
    public void init() {
        customers = IntStream.range(1, 21).mapToObj(this::randomCustomer)
                .collect(Collectors.toConcurrentMap(AbstractEntity::getId, c -> c));
    }

    @Override
    public void addCustomer(Customer customer) {
        Long nextId = nextId(customers);
        customer.setId(nextId);
        customers.put(nextId, customer);
    }

    @Override
    public List<Customer> getCustomers(int start, int size) {
        Stream<Customer> stream = customers.values().stream().skip(start > 0 ? start - 1 : start);
        if (size > 0) {
            return stream.limit(size).collect(Collectors.toList());
        }
        return stream.collect(Collectors.toList());
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        customer.setId(id);
        customers.put(id, customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return Optional.ofNullable(customers.get(id)).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void deleteCustomer(Long id) {
        customers.remove(id);
    }
    
    private Customer randomCustomer(int id) {
        Customer customer = new Customer();
        customer.setId((long) id);
        customer.setFirstName(String.format("FirstName-%s", id));
        customer.setLastName(String.format("LastName-%s", id));
        Address address = new Address();
        address.setCountry(String.format("Country-%s", id % 3));
        address.setState(String.format("State-%s", id % 3));
        address.setCity(String.format("City-%s", id % 5));
        address.setStreet(String.format("Street-%s", id % 7));
        customer.setAddress(address);
        return customer;
    }

}
