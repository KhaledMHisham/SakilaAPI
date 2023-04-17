package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.language.LanguageDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.LanguageMapper;
import gov.iti.jets.sakila.persistence.entities.Language;
import gov.iti.jets.sakila.persistence.repositories.LanguageRepository;

public class LanguageService extends BaseService<Language, LanguageDto, Short> {

    public static final LanguageService INSTANCE = new LanguageService();
    private final LanguageRepository languageRepository = LanguageRepository.getInstance();
    private LanguageService() {
        super(LanguageRepository.getInstance(), LanguageMapper.INSTANCE, Language.class);
    }

    @Override
    public SuccessMessage deleteById(Short languageId){
        Language language = languageRepository.findById(Language.class, languageId);
        language.getLanguageFilms().clear();
        language.getOriginalLanguageFilms().clear();
        languageRepository.deleteById(Language.class, languageId);
        return SuccessMessage.getInstance();
    }
}
