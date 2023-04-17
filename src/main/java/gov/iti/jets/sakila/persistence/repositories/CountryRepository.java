package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Country;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CountryRepository extends CrudRepository<Country, Integer> {
    private static CountryRepository countryRepository = new CountryRepository();
    private CountryRepository(){}
    public static CountryRepository getInstance(){
        return countryRepository;
    }
}
