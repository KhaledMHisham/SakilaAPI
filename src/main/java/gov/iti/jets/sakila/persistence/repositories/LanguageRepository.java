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

    public List<Language> findAll(EntityManager em){
        return super.findAll(Language.class, em);
    }
    public Language findById(Short id, EntityManager em) {
        return super.findById(Language.class, id, em)
                .orElseThrow(() ->
                        new NoSuchElementException("Resource Language Not Found")
                );
    }
    public Language save(Language language, EntityManager entityManager) {
        language.setLastUpdate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        return super.save(language, entityManager);
    }

    public void deleteById(Short id, EntityManager em) {
        super.deleteById(Language.class, id, em);
    }
}
