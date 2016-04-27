package io.github.rebelizant.jaxrsexample;

import io.github.rebelizant.jaxrsexample.rest.CustomerResourceImpl;
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
public class ExampleApplication extends Application {
    
    private Set<Object> singletons = new HashSet<>();

    public ExampleApplication() {
        singletons.add(new CustomerResourceImpl());
    }
    
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

}
