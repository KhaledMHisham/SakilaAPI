package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.controllers.rest.exceptions.IllegalDeleteOperationException;
import gov.iti.jets.sakila.controllers.rest.exceptions.IllegalSaveOperationException;
import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.persistence.entities.BaseEntity;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;
import jakarta.persistence.*;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class CrudRepository<T extends BaseEntity, Id> {
    public List<T> findAll(Class objClass){
        return DatabaseExecutor.execute(entityManager -> {
            String jpql = "SELECT o FROM " + objClass.getSimpleName() +" o";
            Query query = entityManager.createQuery(jpql, List.class);
            return (List<T>) query.getResultList();
        });
    }

    public T insert(T obj){
        return DatabaseExecutor
            .executeInTransaction(entityManager -> {
                try {
                    entityManager.persist(obj);
                } catch (PersistenceException exception) {
                    exception.printStackTrace();
                    throw new IllegalSaveOperationException("Invalid Save Operation On " + obj.getClass().getSimpleName());
                }
                return obj;
            });
    }

    public T update(T obj){
        return DatabaseExecutor
                .executeInTransaction(entityManager -> {
            try{
                entityManager.merge(obj);
            }
            catch (PersistenceException exception){
                throw new IllegalSaveOperationException("Invalid Save Operation On " + obj.getClass().getSimpleName());
            }
            return obj;
        });
    }

    public void deleteById(Class objClass, Id id){
        DatabaseExecutor
            .executeInTransactionWithoutResult(entityManager -> {
                T obj = (T) findById(objClass, id);
                try{
                    entityManager.remove(obj);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                }
                catch (PersistenceException exception){
                    throw new IllegalDeleteOperationException
                            ("Invalid Delete Operation On: " + objClass.getSimpleName());
                }
            });
    }

    public T findById(Class<T> objClass, Id id){
        return DatabaseExecutor.execute(entityManager ->
                 Optional.ofNullable(entityManager.find(objClass, id))
                    .orElseThrow(() ->
                            new ResourceNotFoundException(objClass.getSimpleName() + " Resource Not Found ID: " + id))
        );
    }

    public void delete(T obj){
        DatabaseExecutor
            .executeInTransactionWithoutResult(entityManager -> {
                try {
                    entityManager.remove(obj);
                    entityManager.getTransaction().commit();
                    entityManager.getTransaction().begin();
                }
                catch (PersistenceException exception){
                    throw new IllegalDeleteOperationException
                            ("Invalid Delete Operation On: " + obj.getClass().getSimpleName());
                }
            });
    }
}
