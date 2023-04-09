package gov.iti.jets.sakila.controllers.rest.films;

import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.dtos.messages.ResourceCreatedMessage;
import gov.iti.jets.sakila.services.FilmService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Path("/films/{filmId}/categories/")
public class CategoryController {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{categoryId}")
    public Response addCategoryToFilm(@PathParam("filmId") Integer filmId,
                                      @PathParam("categoryId") Short categoryId){
        try {
            return Response.ok()
                    .entity(FilmService.INSTANCE.addCategoryToFilm(filmId, categoryId))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{categoryId}")
    public Response removeCategoryFromFilm(@PathParam("filmId") Integer filmId,
                                      @PathParam("categoryId") Short categoryId){
        try {
            return Response.ok()
                    .entity(FilmService.INSTANCE.removeCategoryFromFilm(filmId, categoryId))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }
}