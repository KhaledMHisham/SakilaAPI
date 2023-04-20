package gov.iti.jets.sakila.controllers.rest.films;

import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.services.FilmService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Path("/films/{filmId}/languages")
public class LanguageController {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{languageId}")
    public Response addLanguageToFilm(@QueryParam("original") Boolean isOriginal,
                                      @PathParam("languageId") Short languageId,
                                      @PathParam("filmId") Integer filmId){
        return Response.ok()
                .entity(FilmService.INSTANCE.setLanguageToFilm(isOriginal, languageId, filmId))
                .build();
    }

}
