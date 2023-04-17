package gov.iti.jets.sakila.controllers.rest.categories;

import gov.iti.jets.sakila.dtos.category.CategoryDto;
import gov.iti.jets.sakila.services.CategoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/categories")
public class CategoryController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories(){
        return Response.ok()
                .entity(CategoryService.INSTANCE.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewCategories(CategoryDto categoryDto){
        return Response.ok()
                .entity(CategoryService.INSTANCE.insert(categoryDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{categoryId}")
    public Response updateCategory(@PathParam("categoryId") Short categoryId, CategoryDto categoryDto){
        return Response.ok()
            .entity(CategoryService.INSTANCE.update(categoryId, categoryDto))
            .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{categoryId}")
    public Response deleteCategory(@PathParam("categoryId") Short categoryId){
        return Response.ok()
            .entity(CategoryService.INSTANCE.deleteById(categoryId))
            .build();
    }
}
