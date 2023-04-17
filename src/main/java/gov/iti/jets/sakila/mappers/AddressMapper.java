package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.location.AddressDto;
import gov.iti.jets.sakila.persistence.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper extends BaseMapper<Address, AddressDto> {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
}