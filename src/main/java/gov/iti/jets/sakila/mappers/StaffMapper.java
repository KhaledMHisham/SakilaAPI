package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.staff.StaffDto;
import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.entities.Store;
import gov.iti.jets.sakila.persistence.repositories.AddressRepository;
import gov.iti.jets.sakila.persistence.repositories.StoreRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StaffMapper extends BaseMapper<Staff, StaffDto> {
    StaffMapper INSTANCE = Mappers.getMapper(StaffMapper.class);

    @Override
    default Staff partialUpdate(StaffDto dto, Staff entity){
        Integer addressId = dto.getAddress().getId();
        Short storeId = dto.getStore().getId();

        if (dto != null) {
            if (dto.getId() != null) {
                entity.setId(dto.getId());
            }
            if (dto.getUsername() != null) {
                entity.setUsername(dto.getUsername());
            }
            if (dto.getFirstName() != null) {
                entity.setFirstName(dto.getFirstName());
            }
            if (dto.getLastName() != null) {
                entity.setLastName(dto.getLastName());
            }
            if (dto.getEmail() != null){
                entity.setEmail(dto.getEmail());
            }
            if (dto.getActive() != null){
                dto.setActive(entity.getActive());
            }
            if (storeId != null){
                Store store = StoreRepository.getInstance().findById(Store.class, storeId);
                entity.setStore(store);
            }
            if (addressId != null){
                Address address = AddressRepository.getInstance().findById(Address.class, addressId);
                entity.setAddress(address);
            }
        }
        return entity;
    }
}