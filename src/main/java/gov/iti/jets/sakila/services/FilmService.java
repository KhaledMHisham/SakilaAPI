package gov.iti.jets.sakila.services;
import gov.iti.jets.sakila.dtos.film.FilmDto;
import gov.iti.jets.sakila.dtos.film.ActorDto;
import gov.iti.jets.sakila.dtos.messages.ResourceCreatedMessage;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.film.ActorMapper;
import gov.iti.jets.sakila.mappers.film.FilmMapper;
import gov.iti.jets.sakila.persistence.entities.*;
import gov.iti.jets.sakila.persistence.repositories.*;

import java.util.Collection;

public class FilmService extends BaseService<Film, FilmDto, Integer>{

    public final static FilmService INSTANCE = new FilmService();

    private FilmService() {
        super(FilmRepository.getInstance(), FilmMapper.INSTANCE, Film.class);
    }
    private final FilmRepository filmRepository = FilmRepository.getInstance();
    private final FilmMapper filmMapper = FilmMapper.INSTANCE;
    private final LanguageRepository languageRepository = LanguageRepository.getInstance();
    private final ActorRepository actorRepository = ActorRepository.getInstance();
    private final FilmActorRepository filmActorRepository = FilmActorRepository.getInstance();
    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();
    private final FilmCategoryRepository filmCategoryRepository = FilmCategoryRepository.getInstance();


    public Collection<ActorDto> getAllActorsByFilmId(Integer id){
        Film film = filmRepository.findById(Film.class, id);
        return ActorMapper.INSTANCE.collectionToDto(
            film.getFilmActors().stream()
            .map(filmActor -> filmActor.getActor())
            .toList());

    }

    public ResourceCreatedMessage addActorToFilm(Integer filmId, Integer actorId) {
        Actor actor = actorRepository.findById(Actor.class, actorId);
        Film film = filmRepository.findById(Film.class, filmId);
        FilmActor filmActor = new FilmActor(actor, film);
        filmActorRepository.insert(filmActor);
        return new ResourceCreatedMessage();
    }

    public SuccessMessage deleteActorFromFilm(Integer filmId, Integer actorId){
        FilmActorId filmActorId = new FilmActorId();
        filmActorId.setActorId(actorId);
        filmActorId.setFilmId(filmId);
        filmActorRepository.deleteById(FilmActor.class, filmActorId);
        return SuccessMessage.getInstance();
    }

    public SuccessMessage setLanguageToFilm(Boolean isOriginal, Short languageId, Integer filmId){
        Language language = languageRepository.findById(Language.class, languageId);
        Film film = filmRepository.findById(Film.class, filmId);
        if(isOriginal){
            film.setOriginalLanguage(language);
        }
        else{
            film.setLanguage(language);
        }
        filmRepository.update(film);
        return SuccessMessage.getInstance();
    }

    public ResourceCreatedMessage addCategoryToFilm(Integer filmId, Short categoryId) {
        Film film = filmRepository.findById(Film.class, filmId);
        Category category = categoryRepository.findById(Category.class, categoryId);
        FilmCategory filmCategory = new FilmCategory(film, category);
        filmCategoryRepository.insert(filmCategory);
        return ResourceCreatedMessage.getInstance();
    }

    public SuccessMessage removeCategoryFromFilm(Integer filmId, Short categoryId) {
        FilmCategoryId filmCategoryId = new FilmCategoryId(filmId, categoryId);
        filmCategoryRepository.deleteById(FilmCategory.class, filmCategoryId);
        return SuccessMessage.getInstance();
    }
}
