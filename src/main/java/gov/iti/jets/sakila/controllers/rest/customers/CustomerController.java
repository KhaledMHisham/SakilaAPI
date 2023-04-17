package gov.iti.jets.sakila.controllers.rest.customers;

import gov.iti.jets.sakila.dtos.customer.CustomerDto;
import gov.iti.jets.sakila.services.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/customers")
public class CustomerController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers(){
        return Response.ok()
                .entity(CustomerService.INSTANCE.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewCustomer(CustomerDto customerDto){
        return Response.ok()
                .entity(CustomerService.INSTANCE.insert(customerDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{customerId}")
    public Response updateCustomer(@PathParam("customerId") Integer customerId, CustomerDto customerDto){
        return Response.ok()
                .entity(CustomerService.INSTANCE.update(customerId, customerDto))
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{customerId}")
    public Response deleteCustomer(@PathParam("customerId") Integer customerId){
        return Response.ok()
                .entity(CustomerService.INSTANCE.deleteById(customerId))
                .build();
    }
}
