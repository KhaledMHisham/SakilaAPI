package gov.iti.jets.sakila.listeners;

import gov.iti.jets.sakila.persistence.utils.JpaManager;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Created PRODUCTION DATABASE PERSISTENCE UNIT" + JpaManager.PRODUCTION_DATABASE);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        JpaManager.PRODUCTION_DATABASE.closeFactory();
    }
}
