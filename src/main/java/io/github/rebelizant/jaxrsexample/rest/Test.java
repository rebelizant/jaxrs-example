package io.github.rebelizant.jaxrsexample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author rebelizant
 *         Created on 19.04.16
 */
@Path("/")
public class Test {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello World!";
    }

}
