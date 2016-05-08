package io.github.rebelizant.jaxrsexample;

import io.github.rebelizant.jaxrsexample.rest.CustomerResourceImpl;
import io.github.rebelizant.jaxrsexample.rest.mappers.OrderNotFoundExceptionMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@ApplicationPath("/")
public class ExampleApplication extends Application {

    public ExampleApplication() {
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(CustomerResourceImpl.class);
        classes.add(OrderNotFoundExceptionMapper.class);
        return classes;
    }

}
