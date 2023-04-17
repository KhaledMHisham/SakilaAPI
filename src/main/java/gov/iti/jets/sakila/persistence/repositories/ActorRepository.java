package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Actor;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;
import jakarta.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;


public class ActorRepository extends CrudRepository<Actor, Integer>{
    private static ActorRepository actorRepository = new ActorRepository();
    private ActorRepository() {}
    public static ActorRepository getInstance(){
        return actorRepository;
    }

    public void deleteActorFromAllFilms(Actor actor){
        DatabaseExecutor.executeInTransactionWithoutResult(entityManager -> {
            actor.getFilmActors()
                .forEach( filmActor ->
                        entityManager.remove(filmActor)
                );
        });
    }
}
