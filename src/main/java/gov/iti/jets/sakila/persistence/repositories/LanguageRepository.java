package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Language;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class LanguageRepository extends CrudRepository<Language, Short>{
    private static LanguageRepository languageRepository = new LanguageRepository();
    private LanguageRepository(){}
    public static LanguageRepository getInstance(){
        return languageRepository;
    }
}
