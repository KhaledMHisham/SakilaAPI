package gov.iti.jets.sakila.persistence.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;

public abstract class CrudRepository<T, Id> {
    protected List<T> findAll(Class objClass, EntityManager entityManager){
        String jpql = "SELECT o FROM " + objClass.getSimpleName() +" o";
        Query query = entityManager.createQuery(jpql, List.class);
        return (List<T>) query.getResultList();
    }

    protected T save(T obj, EntityManager entityManager){
        entityManager.persist(obj);
        return obj;
    }

    protected Optional<T> deleteById(Class objClass, Id id, EntityManager entityManager){
        Optional<T> obj = findById(objClass, id, entityManager);
        if(obj.isPresent()){
            entityManager.remove(obj.get());
        }
        return obj;
    }

    protected Optional<T> findById(Class<T> objClass, Id id, EntityManager entityManager){
        return Optional.ofNullable(entityManager.find(objClass, id));
    }

    protected void delete(Object obj, EntityManager em){
        em.remove(obj);
    }
}
