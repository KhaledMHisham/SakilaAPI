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

    public List<Category> findAll(EntityManager em){
        return super.findAll(Category.class, em);
    }

    public Category save(Category category, EntityManager em){
        category.setLastUpdate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        return super.save(category, em);
    }

    public Category findById(Short categoryId, EntityManager em) {
        return super.findById(Category.class, categoryId, em)
                    .orElseThrow(() ->
                        new NoSuchElementException("Category Resource Not Found ID: " + categoryId)
        );
    }
    public void remove(Category category, EntityManager em) {
        em.remove(category);
    }
}
