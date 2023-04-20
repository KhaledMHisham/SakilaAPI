package gov.iti.jets.sakila.controllers.rest.actors;


import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.services.ActorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Path("/actors/{actorId}/films")
public class FilmController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilmsByActorId(@PathParam("actorId") Integer actorId){
        return Response.ok().entity(ActorService.INSTANCE.getAllFilmsByActorId(actorId)).build();
    }
}
