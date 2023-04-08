package gov.iti.jets.sakila.persistence.repositories;

public class CountryRepository {
    private static CountryRepository countryRepository = new CountryRepository();
    private CountryRepository(){}
    public static CountryRepository getInstance(){
        return countryRepository;
    }
}
