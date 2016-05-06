package io.github.rebelizant.jaxrsexample;

import io.github.rebelizant.jaxrsexample.rest.CustomerResourceImpl;
import io.github.rebelizant.jaxrsexample.rest.OrderResourceImpl;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;
import java.util.HashSet;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@ApplicationPath("/")
public class ExampleApplication extends ResourceConfig {

    public ExampleApplication() {
        register(io.github.rebelizant.jaxrsexample.rest.CustomerResourceImpl.class);
        register(io.github.rebelizant.jaxrsexample.rest.OrderResourceImpl.class);
    }

}
