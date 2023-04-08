package gov.iti.jets.sakila.controllers.rest.exceptions.mappers;

import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.controllers.rest.exceptions.messages.ResourceNotFoundMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ResourceNotFoundExceptionMapper implements ExceptionMapper<ResourceNotFoundException> {
    @Override
    public Response toResponse(ResourceNotFoundException e) {
        ResourceNotFoundMessage message = new ResourceNotFoundMessage().builder()
                                                                        .status(404)
                                                                        .message(e.getMessage())
                                                                        .build();
        return Response.status(Response.Status.NOT_FOUND).entity(message).build();
    }
}
