package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.City;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class CityRepository extends CrudRepository<City, Integer>{
    private static CityRepository cityRepository = new CityRepository();
    private CityRepository(){}
    public static CityRepository getInstance(){
        return cityRepository;
    }
}
