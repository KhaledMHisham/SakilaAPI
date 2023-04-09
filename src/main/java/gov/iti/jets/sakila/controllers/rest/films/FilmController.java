package gov.iti.jets.sakila.controllers.rest.films;


import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.dtos.FilmDto;
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
                .entity(FilmService.INSTANCE.getAllFilms())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getFilmById(@PathParam("id") Integer id){
        try {
            return Response.ok()
                    .entity(FilmService.INSTANCE.getFilmById(id))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddNewFilm(FilmDto filmDto){
        try {
            return Response.ok()
                    .entity(FilmService.INSTANCE.insertFilm(filmDto))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateFilmById(@PathParam("id") Integer id, FilmDto filmDto){
        try {
            return Response.ok()
                    .entity(FilmService.INSTANCE.updateFilm(id, filmDto))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }
}
