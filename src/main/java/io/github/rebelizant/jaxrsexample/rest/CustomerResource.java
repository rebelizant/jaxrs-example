package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CustomerResource {

    @POST
    void createCustomer(Customer customer);

    @GET
    List<Customer> getCustomers(@QueryParam("start") int start, @QueryParam("size") int size);

    @PUT
    @Path("/{id}")
    void updateCustomer(@PathParam("id") Long id, Customer customer);

    @GET
    @Path("/{id}")
    Customer getCustomer(@PathParam("id") Long id);

    @DELETE
    @Path("/{id}")
    void deleteCustomer(@PathParam("id") Long id);

}
