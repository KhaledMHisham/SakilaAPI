package gov.iti.jets.sakila.persistence.utils;

import jakarta.persistence.EntityManager;

public enum ThreadLocalManager {
    INSTANCE;
    private ThreadLocal<EntityManager> thLocal;

    public EntityManager get() {
        return thLocal.get();
    }

    public void set(EntityManager entityManager){
        thLocal.set(entityManager);
    }
    ThreadLocalManager(){
        thLocal = new ThreadLocal<>();
    }
}
