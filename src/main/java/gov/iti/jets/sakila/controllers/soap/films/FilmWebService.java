package gov.iti.jets.sakila.controllers.soap.films;

import gov.iti.jets.sakila.dtos.film.ActorDto;
import gov.iti.jets.sakila.dtos.film.FilmDto;
import gov.iti.jets.sakila.dtos.messages.ResourceCreatedMessage;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.FilmService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class FilmWebService {
    public Collection<FilmDto> getAllFilms(){
        return FilmService.INSTANCE.findAll();
    }

    public FilmDto getFilmById(Integer id){
        return FilmService.INSTANCE.findById(id);
    }

    public FilmDto AddNewFilm(FilmDto filmDto){
        return FilmService.INSTANCE.insert(filmDto);
    }
    public FilmDto updateFilmById(Integer id, FilmDto filmDto){
        return FilmService.INSTANCE.update(id, filmDto);
    }
    public Collection<ActorDto> getAllActorsByFilmId(Integer filmId){
        return FilmService.INSTANCE.getAllActorsByFilmId(filmId);
    }
    public ResourceCreatedMessage addActorToFilm(Integer filmId, Integer actorId){
        return FilmService.INSTANCE.addActorToFilm(filmId, actorId);
    }
    public SuccessMessage deleteActorFromFilm(Integer filmId, Integer actorId){
        return FilmService.INSTANCE.deleteActorFromFilm(filmId, actorId);
    }

    public SuccessMessage addLanguageToFilm(Boolean isOriginal, Short languageId, Integer filmId){
        return FilmService.INSTANCE.setLanguageToFilm(isOriginal, languageId, filmId);
    }
    public ResourceCreatedMessage addCategoryToFilm(Integer filmId, Short categoryId){
        return FilmService.INSTANCE.addCategoryToFilm(filmId, categoryId);
    }

    public SuccessMessage removeCategoryFromFilm(Integer filmId, Short categoryId){
        return FilmService.INSTANCE.removeCategoryFromFilm(filmId, categoryId);
    }
}
