package io.github.rebelizant.jaxrsexample.rest;

import io.github.rebelizant.jaxrsexample.domain.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author rebelizant
 *         Created on 06.05.16
 */
@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductResource {

    @GET
    @Path("/{id}")
    Product getProduct(@PathParam("id") Long id);

    @POST
    void addProduct(Product product);

    @PUT
    @Path("/{id}")
    void updateProduct(@PathParam("id") Long id, Product product);

    @GET
    List<Product> getProducts(@QueryParam("start") int start, @QueryParam("count") int count);

    @DELETE
    @Path("/{id}")
    void deleteProduct(@PathParam("id") Long id);

}
