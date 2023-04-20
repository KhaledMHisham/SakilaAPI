package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.store.StoreDto;
import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.entities.Store;
import gov.iti.jets.sakila.persistence.repositories.AddressRepository;
import gov.iti.jets.sakila.persistence.repositories.StaffRepository;
import gov.iti.jets.sakila.persistence.repositories.StoreRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StoreMapper extends BaseMapper<Store, StoreDto> {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    @Override
    default Store partialUpdate(StoreDto dto, Store entity){
        Integer addressId = dto.getAddress().getId();
        Short managerId = dto.getManagerStaff().getId();

        if (dto != null) {
            if (dto.getId() != null) {
                entity.setId(dto.getId());
            }
            if (managerId != null){
                Staff manager = StaffRepository.getInstance().findById(Staff.class, managerId);
                entity.setManagerStaff(manager);
            }
            if (addressId != null){
                Address address = AddressRepository.getInstance().findById(Address.class, addressId);
                entity.setAddress(address);
            }
        }
        return entity;
    }
}