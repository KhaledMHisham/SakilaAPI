package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Language;
import jakarta.persistence.EntityManager;

import java.util.NoSuchElementException;
import java.util.Optional;

public class LanguageRepository extends CrudRepository<Language, Short>{
    private static LanguageRepository languageRepository = new LanguageRepository();
    private LanguageRepository(){}
    public static LanguageRepository getInstance(){
        return languageRepository;
    }

    public Language findById(Short id, EntityManager em) {
        return super.findById(Language.class, id, em)
                .orElseThrow(() ->
                        new NoSuchElementException("Resource Language Not Found")
                );
    }
}
