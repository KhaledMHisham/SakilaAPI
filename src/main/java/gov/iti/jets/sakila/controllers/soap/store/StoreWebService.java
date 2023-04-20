package gov.iti.jets.sakila.controllers.soap.store;

import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.dtos.store.StoreDto;
import gov.iti.jets.sakila.services.StoreService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class StoreWebService {
    public Collection<StoreDto> getAllStores(){
        return StoreService.INSTANCE.findAll();
    }
    public StoreDto addNewStore(StoreDto storeDto){
        return StoreService.INSTANCE.insert(storeDto);
    }
    public StoreDto updateStore(Short storeId, StoreDto storeDto){
        return StoreService.INSTANCE.update(storeId, storeDto);
    }
    public SuccessMessage deleteStore(Short storeId){
        return StoreService.INSTANCE.deleteById(storeId);
    }
}
