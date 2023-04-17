package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.inventory.InventoryDto;
import gov.iti.jets.sakila.mappers.InventoryMapper;
import gov.iti.jets.sakila.persistence.entities.Inventory;
import gov.iti.jets.sakila.persistence.repositories.InventoryRepository;

public class InventoryService extends BaseService<Inventory, InventoryDto, Integer>{
    public static final InventoryService INSTANCE = new InventoryService();
    private InventoryService() {
        super(InventoryRepository.getInstance(), InventoryMapper.INSTANCE, Inventory.class);
    }
}
