package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Store;

public class StoreRepository extends CrudRepository<Store, Short>{
    private static StoreRepository storeRepository = new StoreRepository();
    private StoreRepository(){}
    public static StoreRepository getInstance(){
        return storeRepository;
    }
}
