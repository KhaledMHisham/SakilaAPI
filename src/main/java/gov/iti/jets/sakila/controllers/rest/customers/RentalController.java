package gov.iti.jets.sakila.controllers.rest.customers;

import gov.iti.jets.sakila.services.CustomerService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customers/{customerId}/rentals")
public class RentalController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRentalsByCustomerId(@PathParam("customerId") Integer customerId){
        return Response.ok()
                .entity(CustomerService.INSTANCE.findAllRentalsByCustomerId(customerId))
                .build();
    }
}
