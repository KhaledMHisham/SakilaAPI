package gov.iti.jets.sakila.controllers.rest.films;

import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.dtos.film.FilmDto;
import gov.iti.jets.sakila.services.FilmService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.NoSuchElementException;

@Path("/films")
public class FilmController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFilms(){
        return Response.ok()
                .entity(FilmService.INSTANCE.findAll())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getFilmById(@PathParam("id") Integer id){
        return Response.ok()
                .entity(FilmService.INSTANCE.findById(id))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddNewFilm(FilmDto filmDto){
        return Response.ok()
                .entity(FilmService.INSTANCE.insert(filmDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateFilmById(@PathParam("id") Integer id, FilmDto filmDto){
        return Response.ok()
                .entity(FilmService.INSTANCE.update(id, filmDto))
                .build();
    }
}
