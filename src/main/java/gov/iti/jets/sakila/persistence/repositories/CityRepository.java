package gov.iti.jets.sakila.persistence.repositories;

public class CityRepository {
    private static CityRepository cityRepository = new CityRepository();
    private CityRepository(){}
    public static CityRepository getInstance(){
        return cityRepository;
    }
}
