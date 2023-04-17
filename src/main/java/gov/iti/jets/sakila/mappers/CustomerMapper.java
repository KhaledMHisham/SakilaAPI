package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.customer.CustomerDto;
import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.persistence.entities.Customer;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.persistence.entities.Store;
import gov.iti.jets.sakila.persistence.repositories.AddressRepository;
import gov.iti.jets.sakila.persistence.repositories.StoreRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto> {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Override
    default Customer partialUpdate(CustomerDto dto, Customer entity){
        Integer addressId = dto.getAddress().getId();
        Short storeId = dto.getStore().getId();
        if (dto != null) {
            if (dto.getId() != null) {
                entity.setId(dto.getId());
            }
            if(dto.getActive() != null){
                entity.setActive(dto.getActive());
            }
            if (dto.getFirstName() != null) {
                entity.setFirstName(dto.getFirstName());
            }
            if (dto.getLastName() != null) {
                entity.setLastName(dto.getLastName());
            }
            if (dto.getEmail() != null) {
                entity.setEmail(dto.getEmail());
            }
            if(dto.getCreateDate() != null){
                entity.setCreateDate(dto.getCreateDate());
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