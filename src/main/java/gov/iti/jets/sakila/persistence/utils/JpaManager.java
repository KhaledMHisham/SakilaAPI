package gov.iti.jets.sakila.persistence.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public enum JpaManager {

    PRODUCTION_DATABASE;
    private EntityManagerFactory entityManagerFactory;

    public void closeFactory(){entityManagerFactory.close();}
    public EntityManager getEntityManager(){
        return entityManagerFactory.createEntityManager();
    }

    JpaManager(){
        entityManagerFactory = Persistence.createEntityManagerFactory("sakilaPU");
    }

}
