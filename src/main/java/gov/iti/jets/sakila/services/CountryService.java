package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.location.CountryDto;
import gov.iti.jets.sakila.mappers.CountryMapper;
import gov.iti.jets.sakila.persistence.entities.Country;
import gov.iti.jets.sakila.persistence.repositories.CountryRepository;

public class CountryService extends BaseService<Country, CountryDto, Integer>{
    public static final CountryService INSTANCE = new CountryService();
    private CountryRepository countryRepository = CountryRepository.getInstance();
    private CountryService() {
        super(CountryRepository.getInstance(), CountryMapper.INSTANCE, Country.class);
    }
}