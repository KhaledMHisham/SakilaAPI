package gov.iti.jets.sakila.controllers.rest.categories;

import gov.iti.jets.sakila.dtos.CategoryDto;
import gov.iti.jets.sakila.services.CategoryService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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


}
