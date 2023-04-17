package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.actor.ActorDto;
import gov.iti.jets.sakila.dtos.actor.FilmDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.actor.FilmMapper;
import gov.iti.jets.sakila.persistence.entities.Actor;
import gov.iti.jets.sakila.persistence.entities.FilmActor;
import gov.iti.jets.sakila.persistence.repositories.ActorRepository;
import gov.iti.jets.sakila.mappers.actor.ActorMapper;
import java.util.Collection;
import java.util.Set;

public class ActorService extends BaseService<Actor, ActorDto, Integer>{

    public final static ActorService INSTANCE = new ActorService();
    private ActorService() {
        super(ActorRepository.getInstance(), ActorMapper.INSTANCE, Actor.class);
    }
    private ActorRepository actorRepository = ActorRepository.getInstance();

    public SuccessMessage deleteById(Integer id) {
        Actor actor = actorRepository.findById(Actor.class, id);
        actorRepository.deleteActorFromAllFilms(actor);
        actorRepository.delete(actor);
        return SuccessMessage.getInstance();
    }

    public Collection<FilmDto> getAllFilmsByActorId(Integer actorId){
        Actor actor = actorRepository.findById(Actor.class, actorId);
        Set<FilmActor> filmActors =  actor.getFilmActors();
        return FilmMapper.INSTANCE.collectionToDto(
                filmActors.stream()
                .map(filmActor -> filmActor.getFilm())
                .toList());
    }
}