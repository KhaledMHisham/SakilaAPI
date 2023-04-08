package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Film;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class FilmRepository extends CrudRepository<Film, Integer> {
    private static FilmRepository instance = new FilmRepository();
    private FilmRepository(){}
    public static FilmRepository getInstance(){
        return instance;
    }

    public List<Film> findAll(EntityManager entityManager) {
        return super.findAll(Film.class, entityManager);
    }

    @Override
    public Film save(Film film, EntityManager entityManager) {
        film.setLastUpdate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        return super.save(film, entityManager);
    }
    public Film findById(Integer filmId, EntityManager em){
        return super.findById(Film.class, filmId, em)
                .orElseThrow(() ->
                        new NoSuchElementException("Film Resource Not Found ID: " + filmId)
                );
    }
}
