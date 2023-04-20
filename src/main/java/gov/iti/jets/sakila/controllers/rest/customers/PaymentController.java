package gov.iti.jets.sakila.controllers.rest.customers;

import gov.iti.jets.sakila.services.CustomerService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customers/{customerId}/payments")
public class PaymentController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPaymentsByCustomerId(@PathParam("customerId") Integer customerId){
        return Response.ok()
                .entity(CustomerService.INSTANCE.findAllPaymentsByCustomerId(customerId))
                .build();
    }
}