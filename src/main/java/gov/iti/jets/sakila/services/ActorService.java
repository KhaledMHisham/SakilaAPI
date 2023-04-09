package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.ActorDto;
import gov.iti.jets.sakila.dtos.FilmDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.FilmMapper;
import gov.iti.jets.sakila.persistence.entities.Actor;
import gov.iti.jets.sakila.persistence.entities.FilmActor;
import gov.iti.jets.sakila.persistence.repositories.ActorRepository;
import gov.iti.jets.sakila.persistence.repositories.FilmActorRepository;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;
import gov.iti.jets.sakila.mappers.ActorMapper;
import java.util.List;
import java.util.Set;

public enum ActorService {
    INSTANCE;
    private ActorRepository actorRepository = ActorRepository.getInstance();
    private FilmActorRepository filmActorRepository = FilmActorRepository.getInstance();
    public List<ActorDto> getAllActors(){
        List<Actor> actors = DatabaseExecutor
                                .execute(
                                        em -> actorRepository.findAll(em)
                                );
        return actors.stream()
                .map(actor -> ActorMapper.INSTANCE.toDto(actor))
                .toList();
    }

    public ActorDto insertActor(ActorDto actorDto){
        Actor actor = ActorMapper.INSTANCE.toEntity(actorDto);
        return ActorMapper.INSTANCE.toDto(
                DatabaseExecutor
                .executeInTransaction(
                        em -> actorRepository.save(actor, em)
                ));
    }

    public SuccessMessage updateActor(Integer id, ActorDto actorDto){
        DatabaseExecutor
                .executeInTransactionWithoutResult(em -> {
                    Actor actor = actorRepository.findById(id, em);
                    ActorMapper.INSTANCE.partialUpdate(actorDto, actor);
                    actorRepository.save(actor, em);
                }
                );
        return SuccessMessage.getInstance();
    }

    public ActorDto getActorById(Integer id){
        Actor actor = DatabaseExecutor.execute(
                                        em -> actorRepository.findById(id, em)
                                    );
        return ActorMapper.INSTANCE.toDto(actor);
    }

    public SuccessMessage deleteActorById(Integer id) {
        DatabaseExecutor.executeInTransactionWithoutResult(
                em -> {
                    Actor actor = actorRepository.findById(id, em);
                    actorRepository.deleteActorFromAllFilms(actor, em);
                    actorRepository.delete(actor, em);
                }
        );
        return SuccessMessage.getInstance();
    }

    public List<FilmDto> getAllFilmsByActorId(Integer actorId){
        List<FilmDto> result =
            DatabaseExecutor.executeInTransaction(em -> {
                        Actor actor = actorRepository.findById(actorId, em);
                        Set<FilmActor> filmActors =  actor.getFilmActors();

                        return filmActors.stream()
                                .map(filmActor -> filmActor.getFilm())
                                .map(film -> FilmMapper.INSTANCE.toDto(film))
                                .toList();
                    }
            );
        return result;
    }
}