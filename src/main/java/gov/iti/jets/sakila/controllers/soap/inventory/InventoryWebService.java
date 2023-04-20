package gov.iti.jets.sakila.controllers.soap.inventory;

import gov.iti.jets.sakila.dtos.inventory.InventoryDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.InventoryService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;

import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class InventoryWebService {

    public Collection<InventoryDto> getAllInventories(){
        return InventoryService.INSTANCE.findAll();
    }

    public InventoryDto addNewInventoryItem(InventoryDto inventoryDto){
        return InventoryService.INSTANCE.insert(inventoryDto);
    }

    public SuccessMessage deleteInventoryItem(Integer inventoryId){
        return InventoryService.INSTANCE.deleteById(inventoryId);
    }
}
