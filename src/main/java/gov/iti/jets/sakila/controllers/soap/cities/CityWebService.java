package gov.iti.jets.sakila.controllers.soap.cities;

import gov.iti.jets.sakila.dtos.location.AddressDto;
import gov.iti.jets.sakila.dtos.location.CityDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.AddressService;
import gov.iti.jets.sakila.services.CityService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class CityWebService {
    public Collection<CityDto> getAllCities(){
        return CityService.INSTANCE.findAll();
    }
    public CityDto updateCity(Integer cityId, CityDto cityDto){
        return CityService.INSTANCE.update(cityId, cityDto);
    }
    public SuccessMessage deleteCity(Integer cityId){
        return CityService.INSTANCE.deleteById(cityId);
    }
    public Collection<AddressDto> getAllAddressesByCityId(Integer cityId){
        return AddressService.INSTANCE.findAllAddressesByCityId(cityId);
    }
    public CityDto addNewCity(CityDto cityDto){
        return CityService.INSTANCE.insert(cityDto);
    }
}
