package gov.iti.jets.sakila.mappers.film;

import gov.iti.jets.sakila.dtos.film.FilmDto;
import gov.iti.jets.sakila.mappers.BaseMapper;
import gov.iti.jets.sakila.persistence.entities.Film;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmMapper extends BaseMapper<Film, FilmDto> {
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
}