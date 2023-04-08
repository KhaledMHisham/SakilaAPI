package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.LanguageDto;
import gov.iti.jets.sakila.persistence.entities.Language;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);

    Language toEntity(LanguageDto languageDto);

    LanguageDto toDto(Language language);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Language partialUpdate(LanguageDto languageDto, @MappingTarget Language language);
}