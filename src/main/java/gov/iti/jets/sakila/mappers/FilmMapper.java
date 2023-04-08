package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.FilmDto;
import gov.iti.jets.sakila.persistence.entities.Film;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmMapper {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
    Film toEntity(FilmDto filmDto);
    FilmDto toDto(Film film);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Film partialUpdate(FilmDto filmDto, @MappingTarget Film film);
}