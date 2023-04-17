package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.rental.RentalDto;
import gov.iti.jets.sakila.dtos.staff.StaffDto;
import gov.iti.jets.sakila.persistence.entities.*;
import gov.iti.jets.sakila.persistence.repositories.*;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RentalMapper extends BaseMapper<Rental, RentalDto> {
    RentalMapper INSTANCE = Mappers.getMapper(RentalMapper.class);

    @Override
    default Rental partialUpdate(RentalDto dto, Rental entity){
        Integer inventoryId = dto.getInventory().getId();
        Integer customerId = dto.getCustomer().getId();
        Short staffId = dto.getStaff().getId();

        if (dto != null) {
            if (dto.getId() != null) {
                entity.setId(dto.getId());
            }
            if(dto.getRentalDate() != null){
                entity.setRentalDate(dto.getRentalDate());
            }
            if(dto.getReturnDate() != null){
                entity.setReturnDate(dto.getReturnDate());
            }
            if (staffId != null){
                Staff staff = StaffRepository.getInstance().findById(Staff.class, staffId);
                entity.setStaff(staff);
            }
            if (customerId != null){
                Customer customer = CustomerRepository.getInstance().findById(Customer.class, customerId);
                entity.setCustomer(customer);
            }
            if (inventoryId != null){
                Inventory inventory = InventoryRepository.getInstance().findById(Inventory.class, inventoryId);
                entity.setInventory(inventory);
            }
        }
        return entity;
    }
}