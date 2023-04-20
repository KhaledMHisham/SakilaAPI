package gov.iti.jets.sakila.controllers.soap.category;

import gov.iti.jets.sakila.dtos.category.CategoryDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.CategoryService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class CategoryWebService {
    public Collection<CategoryDto> getAllCategories(){
        return CategoryService.INSTANCE.findAll();
    }

    public CategoryDto addNewCategories(CategoryDto categoryDto){
        return CategoryService.INSTANCE.insert(categoryDto);
    }

    public CategoryDto updateCategory(@PathParam("categoryId") Short categoryId, CategoryDto categoryDto){
        return CategoryService.INSTANCE.update(categoryId, categoryDto);
    }

    public SuccessMessage deleteCategory(@PathParam("categoryId") Short categoryId){
        return CategoryService.INSTANCE.deleteById(categoryId);
    }
}
