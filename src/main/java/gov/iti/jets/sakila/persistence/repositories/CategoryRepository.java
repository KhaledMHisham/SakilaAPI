package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Category;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CategoryRepository extends CrudRepository<Category, Short>{

    private static CategoryRepository categoryRepository = new CategoryRepository();
    private CategoryRepository(){}
    public static CategoryRepository getInstance(){
        return categoryRepository;
    }

    public List<Category> findAll(EntityManager em){
        return super.findAll(Category.class, em);
    }

    public Category save(Category category, EntityManager em){
        category.setLastUpdate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        return super.save(category, em);
    }
}
