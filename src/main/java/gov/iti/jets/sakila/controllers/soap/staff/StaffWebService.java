package gov.iti.jets.sakila.controllers.soap.staff;

import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.dtos.staff.StaffDto;
import gov.iti.jets.sakila.services.StaffService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class StaffWebService {

    public Collection<StaffDto> getAllStaff(){
        return StaffService.INSTANCE.findAll();
    }

    public StaffDto getStaffById(Short staffId){
        return StaffService.INSTANCE.findById(staffId);
    }

    public StaffDto AddNewStaff(StaffDto staffDto){
        return StaffService.INSTANCE.insert(staffDto);
    }

    public StaffDto updateStaff(Short staffId, StaffDto staffDto){
        return StaffService.INSTANCE.update(staffId, staffDto);
    }
    public SuccessMessage DeleteStaff(Short staffId){
        return StaffService.INSTANCE.deleteById(staffId);
    }
}
