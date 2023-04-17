package gov.iti.jets.sakila.controllers.rest.exceptions.mappers;

import gov.iti.jets.sakila.controllers.rest.exceptions.IllegalSaveOperationException;
import gov.iti.jets.sakila.controllers.rest.exceptions.messages.IllegalSaveOperationMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IllegalSaveOperationExceptionMapper implements ExceptionMapper<IllegalSaveOperationException> {
    @Override
    public Response toResponse(IllegalSaveOperationException e) {
        IllegalSaveOperationMessage message = new IllegalSaveOperationMessage().builder()
                .status(417)
                .message(e.getMessage())
                .build();
        return Response.status(Response.Status.EXPECTATION_FAILED)
                        .entity(message)
                        .build();
    }
}
