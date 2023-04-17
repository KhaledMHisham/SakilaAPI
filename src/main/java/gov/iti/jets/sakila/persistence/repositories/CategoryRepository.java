package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Category;
import gov.iti.jets.sakila.persistence.entities.FilmCategory;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

public class CategoryRepository extends CrudRepository<Category, Short>{

    private static CategoryRepository categoryRepository = new CategoryRepository();
    private CategoryRepository(){}
    public static CategoryRepository getInstance(){
        return categoryRepository;
    }

}
