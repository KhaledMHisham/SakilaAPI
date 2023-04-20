package gov.iti.jets.sakila.controllers.soap.rentals;

import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.dtos.rental.RentalDto;
import gov.iti.jets.sakila.services.RentalService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class RentalWebService {
    public Collection<RentalDto> getAllRentals(){
        return RentalService.INSTANCE.findAll();
    }
    public RentalDto addNewRental(RentalDto rentalDto){
        return RentalService.INSTANCE.insert(rentalDto);
    }
    public RentalDto updateRental(Integer rentalId, RentalDto rentalDto){
        return RentalService.INSTANCE.update(rentalId, rentalDto);
    }
    public SuccessMessage deleteRental(Integer rentalId){
        return RentalService.INSTANCE.deleteById(rentalId);
    }
}
