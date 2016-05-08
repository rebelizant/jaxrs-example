package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OrderSubResource {
    
    @GET
    @Path("/{orderId}")
    Order getOrder(@PathParam("orderId") Long orderId);

    @GET
    List<Order> getOrders(@PathParam("customerId") Long customerId,
                          @QueryParam("start") int start,
                          @QueryParam("count") int count);
    
}