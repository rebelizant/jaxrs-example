package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Customer;

import javax.ws.rs.*;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Path("/customers")
public interface CustomerResource {

    @POST
    void createCustomer(Customer customer);

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
