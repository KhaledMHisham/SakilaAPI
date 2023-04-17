package gov.iti.jets.sakila.listeners;

import gov.iti.jets.sakila.persistence.utils.JpaManager;
import gov.iti.jets.sakila.persistence.utils.ThreadLocalManager;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {}
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        EntityManager entityManager = ThreadLocalManager.INSTANCE.get();
        ThreadLocalManager.INSTANCE.set(null);
        if(entityManager != null){
            System.out.println("CLOSING ENTITY MANAGER " + entityManager);
            entityManager.close();
        }
    }
}
