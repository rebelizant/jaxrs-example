package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.*;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OrderResource {
    
    @GET
    @Path("/{id}")
    Order getOrder(@PathParam("id") Long id);
    
}