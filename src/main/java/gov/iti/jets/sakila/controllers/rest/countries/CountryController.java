package gov.iti.jets.sakila.controllers.rest.countries;

import gov.iti.jets.sakila.dtos.location.CountryDto;
import gov.iti.jets.sakila.services.CountryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/countries")
public class CountryController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        return Response.ok()
                .entity(CountryService.INSTANCE.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewCountry(CountryDto countryDto){
        return Response.ok()
                .entity(CountryService.INSTANCE.insert(countryDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{countryId}")
    public Response updateCountry(@PathParam("countryId") Integer countryId, CountryDto countryDto){
        return Response.ok()
                .entity(CountryService.INSTANCE.update(countryId, countryDto))
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{countryId}")
    public Response deleteCountry(@PathParam("countryId") Integer countryId){
        return Response.ok()
                .entity(CountryService.INSTANCE.deleteById(countryId))
                .build();
    }
}
