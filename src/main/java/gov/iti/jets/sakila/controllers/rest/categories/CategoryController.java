package gov.iti.jets.sakila.controllers.rest.categories;

import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.dtos.CategoryDto;
import gov.iti.jets.sakila.services.CategoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.NoSuchElementException;

@Path("/categories")
public class CategoryController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories(){
        return Response.ok()
                .entity(CategoryService.INSTANCE.getAllCategories())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewCategories(CategoryDto categoryDto){
        return Response.ok()
                .entity(CategoryService.INSTANCE.addNewCategory(categoryDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{categoryId}")
    public Response updateCategory(@PathParam("categoryId") Short categoryId, CategoryDto categoryDto){
        try {
            return Response.ok()
                    .entity(CategoryService.INSTANCE.updateCategory(categoryId, categoryDto))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{categoryId}")
    public Response deleteCategory(@PathParam("categoryId") Short categoryId){
        try {
            return Response.ok()
                    .entity(CategoryService.INSTANCE.deleteCategory(categoryId))
                    .build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }    }
}
