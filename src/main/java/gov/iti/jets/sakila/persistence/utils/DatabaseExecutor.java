package gov.iti.jets.sakila.persistence.utils;

import jakarta.persistence.EntityManager;
import java.util.function.Consumer;
import java.util.function.Function;

public class DatabaseExecutor {

    public static EntityManager getEntityManager(){
        if(ThreadLocalManager.INSTANCE.get() == null){
            EntityManager entityManager = JpaManager.PRODUCTION_DATABASE.getEntityManager();
            System.out.println("CREATING ENTITY MANAGER " + entityManager);
            ThreadLocalManager.INSTANCE.set(entityManager);
        }
        return ThreadLocalManager.INSTANCE.get();
    }

    public static <R> R execute(Function<EntityManager, R> dbOperation){
        EntityManager entityManager = getEntityManager();
        try {
            R result = dbOperation.apply(entityManager);
            return result;
        }
        catch (RuntimeException exception){
            throw exception;
        }
    }

    public static <R> R executeInTransaction(Function<EntityManager, R> dbOperation){
        EntityManager entityManager = getEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            R result = dbOperation.apply(entityManager);
            transaction.commit();
            return result;
        }
        catch (RuntimeException exception){
            transaction.rollback();
            throw exception;
        }
    }

    public static void executeInTransactionWithoutResult(Consumer<EntityManager> dbOperation){
        EntityManager entityManager = getEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            dbOperation.accept(entityManager);
            transaction.commit();
        }
        catch (RuntimeException exception){
            transaction.rollback();
            throw exception;
        }
    }
}
