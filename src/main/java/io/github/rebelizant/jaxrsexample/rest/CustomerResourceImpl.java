package io.github.rebelizant.jaxrsexample.rest;

import com.google.gson.Gson;
import io.github.rebelizant.jaxrsexample.domain.Customer;
import io.github.rebelizant.jaxrsexample.persistence.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Named
@Singleton
public class CustomerResourceImpl implements CustomerResource {

    @Inject
    private CustomerRepository customerRepository;

    @Inject
    private OrderSubResource orderSubResource;

    @Override
    public Response createCustomer(InputStream inputStream) {
        Customer customer = readCustomer(inputStream);
        customerRepository.addCustomer(customer);
        return Response.created(URI.create("/customers/" + customer.getId()))
                .entity(customer.getId())
                .build();
    }

    @Override
    public StreamingOutput getCustomers(int start, int size) {
        List<Customer> customers = customerRepository.getCustomers(start, size);
        String result = "[" + customers.stream().map(new Gson()::toJson).collect(Collectors.joining(",")) +
                "]";
        return output -> output.write(result.getBytes());
    }

    @Override
    public Response updateCustomer(Long id, InputStream inputStream) {
        customerRepository.updateCustomer(id, readCustomer(inputStream));
        return Response.ok().build();
    }

    @Override
    public StreamingOutput getCustomer(Long id) {
        // Can't inline this variable, because then CustomerNotFoundExceptionMapper won't process exception
        Customer customer = customerRepository.getCustomer(id);
        return output -> output
                .write(new Gson().toJson(customer).getBytes());
    }

    @Override
    public Response deleteCustomer(Long id) {
        customerRepository.deleteCustomer(id);
        return Response.ok().build();
    }

    @Override
    public OrderSubResource getOrderSubResource() {
        return orderSubResource;
    }

    private Customer readCustomer(InputStream inputStream) {
        return new Gson().fromJson(new InputStreamReader(inputStream), Customer.class);
    }
}
