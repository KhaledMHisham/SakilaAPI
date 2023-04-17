package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Inventory;

public class InventoryRepository extends CrudRepository<Inventory, Integer> {
    private static InventoryRepository inventoryRepository = new InventoryRepository();
    private InventoryRepository(){}
    public static InventoryRepository getInstance(){
        return inventoryRepository;
    }
}
