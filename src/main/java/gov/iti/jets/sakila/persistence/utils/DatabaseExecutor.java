package gov.iti.jets.sakila.persistence.utils;

import jakarta.persistence.EntityManager;

import java.util.function.Consumer;
import java.util.function.Function;

public class DatabaseExecutor {

    public static <R> R execute(Function<EntityManager, R> dbOperation){
        var entityManager = JpaManager.PRODUCTION_DATABASE.getEntityManager();
        try {
            R result = dbOperation.apply(entityManager);
            return result;
        }
        catch (RuntimeException exception){
            throw exception;
        }
    }
    public static <R> R executeInTransaction(Function<EntityManager, R> dbOperation){
        var entityManager = JpaManager.PRODUCTION_DATABASE.getEntityManager();
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
        finally {
            entityManager.close();
        }
    }

    public static void executeInTransactionWithoutResult(Consumer<EntityManager> dbOperation){
        var entityManager = JpaManager.PRODUCTION_DATABASE.getEntityManager();
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
        finally {
            entityManager.close();
        }
    }
}
