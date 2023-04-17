package gov.iti.jets.sakila.controllers.rest.languages;

import gov.iti.jets.sakila.dtos.language.LanguageDto;
import gov.iti.jets.sakila.services.LanguageService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/languages")
public class LanguageController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLanguages(){
        return Response.ok()
            .entity(LanguageService.INSTANCE.findAll())
            .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewLanguage(LanguageDto languageDto){
        return Response.ok()
            .entity(LanguageService.INSTANCE.insert(languageDto))
            .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{languageId}")
    public Response updateLanguage(@PathParam("languageId") Short languageId, LanguageDto languageDto){
        return Response.ok()
            .entity(LanguageService.INSTANCE.update(languageId, languageDto))
            .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{languageId}")
    public Response deleteLanguageById(@PathParam("languageId") Short languageId){
        return Response.ok()
            .entity(LanguageService.INSTANCE.deleteById(languageId))
            .build();
    }
}
