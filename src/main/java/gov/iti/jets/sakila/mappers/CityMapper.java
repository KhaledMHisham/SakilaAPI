package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.location.CityDto;
import gov.iti.jets.sakila.persistence.entities.City;
import gov.iti.jets.sakila.persistence.entities.Country;
import gov.iti.jets.sakila.persistence.repositories.CountryRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CityMapper extends BaseMapper<City, CityDto> {

    CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

    @Override
    default City partialUpdate(CityDto dto, City entity){
        Integer countryId = dto.getCountry().getId();

        if (dto != null) {
            if (dto.getId() != null) {
                entity.setId(dto.getId());
            }
            if (dto.getCity() != null) {
                entity.setCity(dto.getCity());
            }
            if (dto.getCountry() != null) {
                Country country = CountryRepository.getInstance().findById(Country.class, countryId);
                entity.setCountry(country);
            }
        }
        return entity;
    }
}