package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.dtos.staff.StaffDto;
import gov.iti.jets.sakila.dtos.store.StoreDto;
import gov.iti.jets.sakila.mappers.StaffMapper;
import gov.iti.jets.sakila.mappers.StoreMapper;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.entities.Store;
import gov.iti.jets.sakila.persistence.repositories.StaffRepository;
import gov.iti.jets.sakila.persistence.repositories.StoreRepository;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.Collection;

public class StoreService extends BaseService<Store, StoreDto, Short>{

    public static final StoreService INSTANCE = new StoreService();
    private StaffMapper staffMapper = StaffMapper.INSTANCE;
    private StoreRepository storeRepository = StoreRepository.getInstance();
    private StaffRepository staffRepository = StaffRepository.getInstance();
    private StoreService() {
        super(StoreRepository.getInstance(), StoreMapper.INSTANCE, Store.class);
    }

    public Collection<StaffDto> findAllStaffByStoreId(Short storeId) {
        Store store = storeRepository.findById(Store.class, storeId);
        Collection<Staff> staff = store.getStaff();
        staff.add(store.getManagerStaff());
        return staffMapper.collectionToDto(staff);
    }

    public StaffDto addStaffToStore(Short storeId, Short staffId) {
        Store store = storeRepository.findById(Store.class, storeId);
        Staff staff = staffRepository.findById(Staff.class, staffId);
        staff.setStore(store);
        staffRepository.update(staff);
        return staffMapper.toDto(staff);
    }
}
