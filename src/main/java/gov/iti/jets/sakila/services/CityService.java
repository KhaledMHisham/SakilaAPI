package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.location.CityDto;
import gov.iti.jets.sakila.mappers.CityMapper;
import gov.iti.jets.sakila.persistence.entities.City;
import gov.iti.jets.sakila.persistence.entities.Country;
import gov.iti.jets.sakila.persistence.repositories.CityRepository;
import gov.iti.jets.sakila.persistence.repositories.CountryRepository;

import java.util.Collection;

public class CityService extends BaseService<City, CityDto, Integer>{

    public final static CityService INSTANCE = new CityService();
    private final CountryRepository countryRepository = CountryRepository.getInstance();
    private final CityMapper cityMapper = CityMapper.INSTANCE;
    private final CityRepository cityRepository = CityRepository.getInstance();
    private CityService() {
        super(CityRepository.getInstance(), CityMapper.INSTANCE, City.class);
    }

    public Collection<CityDto> findCitiesByCountryId(Integer countryId){
        Country country = countryRepository.findById(Country.class, countryId);
        return cityMapper.collectionToDto(country.getCities());
    }

}
