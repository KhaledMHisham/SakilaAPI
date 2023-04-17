package gov.iti.jets.sakila.controllers.rest.exceptions.mappers;

import gov.iti.jets.sakila.controllers.rest.exceptions.IllegalDeleteOperationException;
import gov.iti.jets.sakila.controllers.rest.exceptions.messages.IllegalDeleteOperationMessage;
import gov.iti.jets.sakila.controllers.rest.exceptions.messages.IllegalSaveOperationMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class IllegalDeleteOperationExceptionMapper implements ExceptionMapper<IllegalDeleteOperationException> {
    @Override
    public Response toResponse(IllegalDeleteOperationException e) {
        IllegalDeleteOperationMessage message = new IllegalDeleteOperationMessage().builder()
                .status(417)
                .message(e.getMessage())
                .build();
        return Response.status(Response.Status.EXPECTATION_FAILED)
                .entity(message)
                .build();
    }
}
