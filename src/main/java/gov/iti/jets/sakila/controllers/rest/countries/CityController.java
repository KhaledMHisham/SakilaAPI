package gov.iti.jets.sakila.controllers.rest.countries;

import gov.iti.jets.sakila.dtos.location.CityDto;
import gov.iti.jets.sakila.services.CityService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/countries/{countryId}/cities")
public class CityController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCitiesByCountryId(@PathParam("countryId") Integer countryId){
        return Response.ok()
                .entity(CityService.INSTANCE.findCitiesByCountryId(countryId))
                .build();
    }
}
