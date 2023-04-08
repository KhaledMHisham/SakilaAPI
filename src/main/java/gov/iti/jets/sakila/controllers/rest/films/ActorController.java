package gov.iti.jets.sakila.controllers.rest.films;


import gov.iti.jets.sakila.services.actors.FilmService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/films/{filmId}/actors")
public class ActorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActorsByFilmId(@PathParam("filmId") Integer filmId){
        return Response.ok().entity(FilmService.INSTANCE.getAllActorsByFilmId(filmId)).build();
    }
    @POST
    @Path("{actorId}")
    public Response addActorToFilm(@PathParam("filmId") Integer filmId,
                                   @PathParam("actorId") Integer actorId){
        return Response.ok().entity(FilmService.INSTANCE.addActorToFilm(filmId, actorId)).build();
    }
}
