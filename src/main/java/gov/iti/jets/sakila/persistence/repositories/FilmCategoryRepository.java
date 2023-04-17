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

}
