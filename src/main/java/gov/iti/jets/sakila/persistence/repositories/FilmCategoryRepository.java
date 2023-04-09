package gov.iti.jets.sakila.persistence.repositories;


import gov.iti.jets.sakila.persistence.entities.FilmActor;
import gov.iti.jets.sakila.persistence.entities.FilmActorId;
import gov.iti.jets.sakila.persistence.entities.FilmCategory;
import gov.iti.jets.sakila.persistence.entities.FilmCategoryId;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;

public class FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryId>{
    private static FilmCategoryRepository filmCategoryRepository = new FilmCategoryRepository();
    private FilmCategoryRepository(){}
    public static FilmCategoryRepository getInstance(){
        return filmCategoryRepository;
    }

    public FilmCategory save(FilmCategory filmCategory, EntityManager em){
        filmCategory.setLastUpdate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        return super.save(filmCategory, em);
    }
    public void deleteById(FilmCategoryId filmCategoryId, EntityManager em){
        super.deleteById(FilmCategory.class, filmCategoryId, em);
    }
    public void remove(FilmCategory filmCategory, EntityManager em) {
        em.remove(filmCategory);
    }
}
