package gov.iti.jets.sakila.persistence.repositories;

public class StoreRepository {
    private static StoreRepository storeRepository = new StoreRepository();
    private StoreRepository(){}
    public static StoreRepository getInstance(){
        return storeRepository;
    }
}
