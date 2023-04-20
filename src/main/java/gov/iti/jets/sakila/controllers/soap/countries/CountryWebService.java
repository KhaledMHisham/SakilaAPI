package gov.iti.jets.sakila.controllers.soap.countries;

import gov.iti.jets.sakila.dtos.location.CityDto;
import gov.iti.jets.sakila.dtos.location.CountryDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.CityService;
import gov.iti.jets.sakila.services.CountryService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class CountryWebService {
    public Collection<CountryDto> getAllCountries(){
        return CountryService.INSTANCE.findAll();
    }
    public CountryDto addNewCountry(CountryDto countryDto){
        return CountryService.INSTANCE.insert(countryDto);
    }

    public CountryDto updateCountry(Integer countryId, CountryDto countryDto){
        return CountryService.INSTANCE.update(countryId, countryDto);
    }
    public SuccessMessage deleteCountry(Integer countryId){
        return CountryService.INSTANCE.deleteById(countryId);
    }
    public Collection<CityDto> getCitiesByCountryId(Integer countryId){
        return CityService.INSTANCE.findCitiesByCountryId(countryId);
    }
}
