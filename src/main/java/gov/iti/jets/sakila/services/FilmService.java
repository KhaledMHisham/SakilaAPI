package gov.iti.jets.sakila.services;
import gov.iti.jets.sakila.dtos.ActorDto;
import gov.iti.jets.sakila.dtos.FilmDto;
import gov.iti.jets.sakila.dtos.messages.ResourceCreatedMessage;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.ActorMapper;
import gov.iti.jets.sakila.mappers.FilmMapper;
import gov.iti.jets.sakila.persistence.entities.*;
import gov.iti.jets.sakila.persistence.repositories.*;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

public enum FilmService {
    INSTANCE;
    private final FilmRepository filmRepository = FilmRepository.getInstance();
    private final LanguageRepository languageRepository = LanguageRepository.getInstance();
    private final ActorRepository actorRepository = ActorRepository.getInstance();
    private final FilmActorRepository filmActorRepository = FilmActorRepository.getInstance();
    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();
    private final FilmCategoryRepository filmCategoryRepository = FilmCategoryRepository.getInstance();

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

        DatabaseExecutor.executeInTransactionWithoutResult(em -> {
            Actor actor = actorRepository.findById(actorId, em);
            Film film = filmRepository.findById(filmId, em);
            FilmActor filmActor = new FilmActor(actor, film);

            filmActorRepository.save(filmActor, em);
            filmRepository.save(film, em);
            actorRepository.save(actor, em);
        });
        return new ResourceCreatedMessage();
    }

    public SuccessMessage deleteActorFromFilm(Integer filmId, Integer actorId){
        FilmActorId filmActorId = new FilmActorId();
        filmActorId.setActorId(actorId);
        filmActorId.setFilmId(filmId);
        DatabaseExecutor.executeInTransactionWithoutResult(em -> {
            filmActorRepository.deleteById(filmActorId, em);
        });
        return SuccessMessage.getInstance();
    }

    public SuccessMessage setLanguageToFilm(Boolean isOriginal, Short languageId, Integer filmId){
        DatabaseExecutor.executeInTransactionWithoutResult(em -> {
            Language language = languageRepository.findById(languageId, em);
            Film film = filmRepository.findById(filmId, em);
            if(isOriginal){
                film.setOriginalLanguage(language);
            }
            else{
                film.setLanguage(language);
            }
            filmRepository.save(film, em);
        });
        return SuccessMessage.getInstance();
    }

    public ResourceCreatedMessage addCategoryToFilm(Integer filmId, Short categoryId) {
        DatabaseExecutor.executeInTransactionWithoutResult( em -> {
            Film film = filmRepository.findById(filmId, em);
            Category category = categoryRepository.findById(categoryId, em);
            FilmCategory filmCategory = new FilmCategory(film, category);
            filmCategoryRepository.save(filmCategory, em);
        });
        return ResourceCreatedMessage.getInstance();
    }

    public SuccessMessage removeCategoryFromFilm(Integer filmId, Short categoryId) {
        DatabaseExecutor.executeInTransactionWithoutResult(em -> {
            FilmCategoryId filmCategoryId = new FilmCategoryId(filmId, categoryId);
            System.out.println(filmCategoryId);
            filmCategoryRepository.deleteById(filmCategoryId, em);
        });
        return SuccessMessage.getInstance();
    }
}
