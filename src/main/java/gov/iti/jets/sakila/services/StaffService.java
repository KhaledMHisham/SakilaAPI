package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.staff.StaffDto;
import gov.iti.jets.sakila.mappers.StaffMapper;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.repositories.StaffRepository;
import gov.iti.jets.sakila.persistence.repositories.StoreRepository;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;

public class StaffService extends BaseService<Staff, StaffDto, Short>{

    public static final StaffService INSTANCE = new StaffService();
    public static final StaffRepository staffRepository = StaffRepository.getInstance();
    public static final StoreRepository storeRepository = StoreRepository.getInstance();
    public static final StaffMapper staffMapper = StaffMapper.INSTANCE;
    private StaffService() {
        super(StaffRepository.getInstance(), StaffMapper.INSTANCE, Staff.class);
    }

}
