package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.FilmCategoryDto;
import gov.iti.jets.sakila.persistence.entities.FilmCategory;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FilmCategoryMapper {

    FilmCategoryMapper INSTANCE = Mappers.getMapper(FilmCategoryMapper.class);
    FilmCategory toEntity(FilmCategoryDto filmCategoryDto);
    FilmCategoryDto toDto(FilmCategory filmCategory);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FilmCategory partialUpdate(FilmCategoryDto filmCategoryDto, @MappingTarget FilmCategory filmCategory);
}