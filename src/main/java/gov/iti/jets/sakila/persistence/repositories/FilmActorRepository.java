package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.FilmActor;
import gov.iti.jets.sakila.persistence.entities.FilmActorId;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class FilmActorRepository extends CrudRepository<FilmActor, FilmActorId>{
    private static FilmActorRepository filmActorRepository = new FilmActorRepository();
    private FilmActorRepository(){}
    public static FilmActorRepository getInstance(){
        return filmActorRepository;
    }


    public FilmActor save(FilmActor filmActor, EntityManager entityManager) {
        filmActor.setLastUpdate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        return super.save(filmActor, entityManager);
    }

    public void delete(Object obj, EntityManager em) {
        super.delete(obj, em);
    }

    public void deleteById(FilmActorId id, EntityManager em){
        super.deleteById(FilmActor.class, id, em);
    }
}
