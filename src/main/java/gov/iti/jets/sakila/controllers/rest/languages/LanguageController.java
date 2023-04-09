package gov.iti.jets.sakila.controllers.rest.languages;

import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.dtos.LanguageDto;
import gov.iti.jets.sakila.services.LanguageService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.NoSuchElementException;

@Path("/languages")
public class LanguageController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLanguages(){
        return Response.ok()
                .entity(LanguageService.INSTANCE.getAllLanguages())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewLanguage(LanguageDto languageDto){
        return Response.ok()
                .entity(LanguageService.INSTANCE.addNewLanguage(languageDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{languageId}")
    public Response updateLanguage(@PathParam("languageId") Short languageId, LanguageDto languageDto){
        try {
            return Response.ok()
                    .entity(LanguageService.INSTANCE.updateLanguage(languageId, languageDto))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{languageId}")
    public Response deleteLanguageById(@PathParam("languageId") Short languageId){
        try {
            return Response.ok()
                    .entity(LanguageService.INSTANCE.deleteLanguageById(languageId))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }
}
