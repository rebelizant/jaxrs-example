package io.github.rebelizant.jaxrsexample.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.InputStream;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface CustomerResource {

    @POST
    Response createCustomer(InputStream inputStream);

    @GET
    StreamingOutput getCustomers(@QueryParam("start") int start, @QueryParam("size") int size);

    @PUT
    @Path("/{id: \\d+}")
    Response updateCustomer(@PathParam("id") Long id, InputStream inputStream);

    @GET
    @Path("/{id: \\d+}")
    StreamingOutput getCustomer(@PathParam("id") Long id);

    @DELETE
    @Path("/{id: \\d+}")
    Response deleteCustomer(@PathParam("id") Long id);

    @Path("{customerId: \\d+}/orders")
    OrderSubResource getOrderSubResource();

}
