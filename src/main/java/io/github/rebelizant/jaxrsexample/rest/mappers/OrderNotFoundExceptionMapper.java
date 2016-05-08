package io.github.rebelizant.jaxrsexample.rest.mappers;

import io.github.rebelizant.jaxrsexample.exception.ErrorMessage;
import io.github.rebelizant.jaxrsexample.exception.OrderNotFoundException;

import javax.inject.Named;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author rebelizant
 *         Created on 08.05.16
 */
@Provider
@Named
public class OrderNotFoundExceptionMapper implements ExceptionMapper<OrderNotFoundException> {

    @Override
    public Response toResponse(OrderNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(new ErrorMessage(exception.getMessage(), 404, "https://github.com/rebelizant/jaxrs-example"))
                .build();
    }
}
