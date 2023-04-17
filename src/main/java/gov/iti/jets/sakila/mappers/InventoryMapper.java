package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.inventory.InventoryDto;
import gov.iti.jets.sakila.mappers.BaseMapper;
import gov.iti.jets.sakila.persistence.entities.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper extends BaseMapper<Inventory, InventoryDto> {
    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);
}