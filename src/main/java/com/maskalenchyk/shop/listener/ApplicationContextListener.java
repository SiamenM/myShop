package com.maskalenchyk.shop.listener;

import com.maskalenchyk.shop.service.ServiceManager;
import com.maskalenchyk.shop.service.ServiceManagerImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(ApplicationContextListener.class);
    private ServiceManager serviceManager;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        this.serviceManager = ServiceManagerImpl.getInstance(sce.getServletContext());
        LOGGER.info("Application initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        serviceManager.close();
        LOGGER.info("Application destroyed");
    }
}
