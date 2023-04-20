package gov.iti.jets.sakila.controllers.soap.addresses;

import gov.iti.jets.sakila.dtos.location.AddressDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.AddressService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import java.util.Collection;
@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class AddressWebService {
    public Collection<AddressDto> getAllAddresses(){
        return AddressService.INSTANCE.findAll();
    }
    public AddressDto AddNewAddress(AddressDto addressDto){
        return AddressService.INSTANCE.insert(addressDto);
    }
    public AddressDto UpdateAddress(Integer addressId, AddressDto addressDto){
        return AddressService.INSTANCE.update(addressId, addressDto);
    }
    public SuccessMessage DeleteAddress(Integer addressId){
        return AddressService.INSTANCE.deleteById(addressId);
    }
}
