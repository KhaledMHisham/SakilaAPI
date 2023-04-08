package gov.iti.jets.sakila.controllers.rest.actors;


import gov.iti.jets.sakila.services.actors.ActorService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/actors/{uid}/films")
public class FilmController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilms(@PathParam("uid") Integer uid){
        return Response.ok(ActorService.INSTANCE.getAllActors(), "films").build();
    }
}
