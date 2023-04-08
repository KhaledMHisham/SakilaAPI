package gov.iti.jets.sakila.persistence.repositories;

public class InventoryRepository {
    private static InventoryRepository inventoryRepository = new InventoryRepository();
    private InventoryRepository(){}
    public static InventoryRepository getInstance(){
        return inventoryRepository;
    }
}
