package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.payment.PaymentDto;
import gov.iti.jets.sakila.dtos.rental.RentalDto;
import gov.iti.jets.sakila.persistence.entities.*;
import gov.iti.jets.sakila.persistence.repositories.CustomerRepository;
import gov.iti.jets.sakila.persistence.repositories.InventoryRepository;
import gov.iti.jets.sakila.persistence.repositories.StaffRepository;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper extends BaseMapper<Payment, PaymentDto> {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Override
    default Payment partialUpdate(PaymentDto dto, Payment entity){
        Integer customerId = dto.getCustomer().getId();
        Short staffId = dto.getStaff().getId();
        if (dto != null) {
            if (dto.getId() != null) {
                entity.setId(dto.getId());
            }
            if(dto.getPaymentDate() != null){
                entity.setPaymentDate(dto.getPaymentDate());
            }
            if(dto.getAmount() != null){
                entity.setAmount(dto.getAmount());
            }
            if(customerId != null){
                Customer customer = CustomerRepository.getInstance().findById(Customer.class, customerId);
                entity.setCustomer(customer);
            }
            if(staffId != null){
                Staff staff = StaffRepository.getInstance().findById(Staff.class, staffId);
                entity.setStaff(staff);
            }
        }
        return entity;
    }

}