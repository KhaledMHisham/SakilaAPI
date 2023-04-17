package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.location.CountryDto;
import gov.iti.jets.sakila.persistence.entities.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper extends BaseMapper<Country, CountryDto> {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

}