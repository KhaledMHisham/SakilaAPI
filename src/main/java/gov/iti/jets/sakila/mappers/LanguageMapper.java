package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.language.LanguageDto;
import gov.iti.jets.sakila.persistence.entities.Language;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LanguageMapper extends BaseMapper<Language, LanguageDto> {
    LanguageMapper INSTANCE = Mappers.getMapper(LanguageMapper.class);
}