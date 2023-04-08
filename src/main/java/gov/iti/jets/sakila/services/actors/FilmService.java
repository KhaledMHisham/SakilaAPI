package gov.iti.jets.sakila.services.actors;
import gov.iti.jets.sakila.dtos.ActorDto;
import gov.iti.jets.sakila.dtos.FilmDto;
import gov.iti.jets.sakila.dtos.messages.ResourceCreatedMessage;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.ActorMapper;
import gov.iti.jets.sakila.mappers.FilmMapper;
import gov.iti.jets.sakila.persistence.entities.*;
import gov.iti.jets.sakila.persistence.repositories.ActorRepository;
import gov.iti.jets.sakila.persistence.repositories.FilmActorRepository;
import gov.iti.jets.sakila.persistence.repositories.FilmRepository;
import gov.iti.jets.sakila.persistence.repositories.LanguageRepository;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public enum FilmService {
    INSTANCE;
    private FilmRepository filmRepository = FilmRepository.getInstance();
    private LanguageRepository languageRepository = LanguageRepository.getInstance();
    private ActorRepository actorRepository = ActorRepository.getInstance();
    private FilmActorRepository filmActorRepository = FilmActorRepository.getInstance();
    public List<FilmDto> getAllFilms(){
        List<Film> films = DatabaseExecutor.execute(
                em -> filmRepository.findAll(em)
        );

        List<FilmDto> result = films.stream()
                                    .map(film -> FilmMapper.INSTANCE.toDto(film))
                                    .toList();
        return result;
    }

    public FilmDto getFilmById(Integer id){
        Film film = DatabaseExecutor.execute(
                em -> filmRepository.findById(id, em)
        );
        return FilmMapper.INSTANCE.toDto(film);
    }

    public ResourceCreatedMessage insertFilm(FilmDto filmDto){
        Film film = FilmMapper.INSTANCE.toEntity(filmDto);
        Short languageId = film.getLanguage().getId();
        DatabaseExecutor.executeInTransactionWithoutResult(em ->{
            Language language = languageRepository.findById(languageId, em);
            film.setLanguage(language);
            filmRepository.save(film, em);
            });
        return ResourceCreatedMessage.getInstance();
    }

    public SuccessMessage updateFilm(Integer id, FilmDto filmDto) {
        Short languageId = filmDto.getLanguage().getId();
        DatabaseExecutor
            .executeInTransactionWithoutResult(em -> {
                Language language = languageRepository.findById(languageId, em);
                Film updatedFilm = filmRepository.findById(id, em);
                FilmMapper.INSTANCE.partialUpdate(filmDto, updatedFilm);
                updatedFilm.setLanguage(language);
                filmRepository.save(updatedFilm, em);
            });
        return SuccessMessage.getInstance();
    }

    public List<ActorDto> getAllActorsByFilmId(Integer id){
        Film resultFilm =
            DatabaseExecutor.execute(em->{
                Film film = filmRepository.findById(id, em);
                film.getFilmActors();
                return film;
            });
        return resultFilm.getFilmActors()
                .stream()
                .map(filmActor -> filmActor.getActor())
                .map(actor -> ActorMapper.INSTANCE.toDto(actor))
                .toList();
    }

    public ResourceCreatedMessage addActorToFilm(Integer filmId, Integer actorId) {
        FilmActor filmActor = new FilmActor();
        DatabaseExecutor.executeInTransactionWithoutResult(em -> {
            Actor actor = actorRepository.findById(actorId, em);
            Film film = filmRepository.findById(filmId, em);

            filmActor.setFilm(film);
            filmActor.setActor(actor);

            filmActorRepository.save(filmActor, em);
            filmRepository.save(film, em);
            actorRepository.save(actor, em);
        });
        return new ResourceCreatedMessage();
    }
}
