package gov.iti.jets.sakila.controllers.rest.films;


import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.services.FilmService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Path("/films/{filmId}/actors")
public class ActorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActorsByFilmId(@PathParam("filmId") Integer filmId){
        try {
            return Response.ok().entity(FilmService.INSTANCE.getAllActorsByFilmId(filmId)).build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }
    @POST
    @Path("{actorId}")
    public Response addActorToFilm(@PathParam("filmId") Integer filmId,
                                   @PathParam("actorId") Integer actorId){
        try {
            return Response.ok().entity(FilmService.INSTANCE.addActorToFilm(filmId, actorId)).build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @DELETE
    @Path("{actorId}")
    public Response deleteActorFromFilm(@PathParam("filmId") Integer filmId,
                                        @PathParam("actorId") Integer actorId){
        try {
            return Response.ok().entity(FilmService.INSTANCE.deleteActorFromFilm(filmId, actorId)).build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }
}
