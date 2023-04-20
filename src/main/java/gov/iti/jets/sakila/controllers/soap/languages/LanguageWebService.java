package gov.iti.jets.sakila.controllers.soap.languages;

import gov.iti.jets.sakila.dtos.language.LanguageDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.LanguageService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import java.util.Collection;
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class LanguageWebService {
    public Collection<LanguageDto> getAllLanguages(){
        return LanguageService.INSTANCE.findAll();
    }
    public LanguageDto addNewLanguage(LanguageDto languageDto){
        return LanguageService.INSTANCE.insert(languageDto);
    }
    public LanguageDto updateLanguage(Short languageId, LanguageDto languageDto){
        return LanguageService.INSTANCE.update(languageId, languageDto);
    }
    public SuccessMessage deleteLanguageById(Short languageId){
        return LanguageService.INSTANCE.deleteById(languageId);
    }
}
