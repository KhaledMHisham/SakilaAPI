package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.LanguageDto;
import gov.iti.jets.sakila.dtos.messages.ResourceCreatedMessage;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.LanguageMapper;
import gov.iti.jets.sakila.persistence.entities.Language;
import gov.iti.jets.sakila.persistence.repositories.LanguageRepository;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;

import java.util.List;

public enum LanguageService {

    INSTANCE;
    private final LanguageRepository languageRepository = LanguageRepository.getInstance();

    public List<LanguageDto> getAllLanguages(){
        return DatabaseExecutor.execute( em ->
                        languageRepository.findAll(em)
                                .stream()
                                .map(language -> LanguageMapper.INSTANCE.toDto(language))
                                .toList()
                );
    }
    public ResourceCreatedMessage addNewLanguage(LanguageDto languageDto){
        DatabaseExecutor.executeInTransactionWithoutResult( em -> {
            languageRepository.save(LanguageMapper.INSTANCE.toEntity(languageDto), em);
        });
        return ResourceCreatedMessage.getInstance();
    }

    public SuccessMessage updateLanguage(Short languageId, LanguageDto languageDto){
        DatabaseExecutor.executeInTransactionWithoutResult( em-> {
            Language language = languageRepository.findById(languageId, em);
            LanguageMapper.INSTANCE.partialUpdate(languageDto, language);
            languageRepository.save(language, em);
        });
        return SuccessMessage.getInstance();
    }

    public SuccessMessage deleteLanguageById(Short languageId){
        DatabaseExecutor.executeInTransactionWithoutResult( em-> {
            Language language = languageRepository.findById(languageId, em);
            language.getLanguageFilms().clear();
            language.getOriginalLanguageFilms().clear();
            languageRepository.deleteById(languageId, em);
        });
        return SuccessMessage.getInstance();
    }
}
