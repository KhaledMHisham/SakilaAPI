package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Actor;
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

    public Actor save(Actor actor, EntityManager entityManager) {
        actor.setLastUpdate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        return super.save(actor, entityManager);
    }

    public List<Actor> findAll(EntityManager entityManager) {
        return super.findAll(Actor.class, entityManager);
    }

    public Actor findById(Integer id, EntityManager entityManager) {
        return super.findById(Actor.class, id, entityManager)
                .orElseThrow(() ->
                new NoSuchElementException("Actor Resource Not Found ID: " + id)
        );
    }
    public Actor deleteById(Integer id, EntityManager entityManager) {
        return super.deleteById(Actor.class, id, entityManager)
                .orElseThrow(() ->
                        new NoSuchElementException("Actor Resource Not Found ID: " + id)
                );
    }
    public void delete(Object obj, EntityManager em) {
        super.delete(obj, em);
    }

    public void deleteActorFromAllFilms(Actor actor, EntityManager em){
        actor.getFilmActors()
                .forEach( filmActor ->
                        super.delete(filmActor, em)
                );
    }
}
