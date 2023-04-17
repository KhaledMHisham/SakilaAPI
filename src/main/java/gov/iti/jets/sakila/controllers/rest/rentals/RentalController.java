package gov.iti.jets.sakila.controllers.rest.rentals;
import gov.iti.jets.sakila.dtos.rental.RentalDto;
import gov.iti.jets.sakila.services.RentalService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
@Path("/rentals")
public class RentalController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRentals(){
        return Response.ok()
                .entity(RentalService.INSTANCE.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewRental(RentalDto rentalDto){
        return Response.ok()
                .entity(RentalService.INSTANCE.insert(rentalDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{rentalId}")
    public Response addNewRental(@PathParam("rentalId") Integer rentalId, RentalDto rentalDto){
        return Response.ok()
                .entity(RentalService.INSTANCE.update(rentalId, rentalDto))
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{rentalId}")
    public Response deleteRental(@PathParam("rentalId") Integer rentalId){
        return Response.ok()
                .entity(RentalService.INSTANCE.deleteById(rentalId))
                .build();
    }
}