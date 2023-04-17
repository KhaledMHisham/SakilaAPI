package gov.iti.jets.sakila.controllers.rest.cities;

import gov.iti.jets.sakila.dtos.location.CityDto;
import gov.iti.jets.sakila.services.CityService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cities")
public class CityController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCities(){
        return Response.ok()
                .entity(CityService.INSTANCE.findAll())
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cityId}")
    public Response updateCity(@PathParam("cityId") Integer cityId, CityDto cityDto){
        return Response.ok()
            .entity(CityService.INSTANCE.update(cityId, cityDto))
            .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cityId}")
    public Response deleteCity(@PathParam("cityId") Integer cityId){
        return Response.ok()
                .entity(CityService.INSTANCE.deleteById(cityId))
                .build();
    }
}
