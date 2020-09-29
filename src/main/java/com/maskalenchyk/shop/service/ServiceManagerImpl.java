package com.maskalenchyk.shop.service;

import javax.servlet.ServletContext;

public class ServiceManagerImpl implements ServiceManager {

    private ServiceManagerImpl(ServletContext context) {
    }

    public static ServiceManager getInstance(ServletContext context) {
        ServiceManager serviceManager = (ServiceManager) context.getAttribute("SERVICE_MANAGER");
        if (serviceManager == null) {
            serviceManager = new ServiceManagerImpl(context);
            context.setAttribute("SERVICE_MANAGER", serviceManager);
        }
        return serviceManager;
    }

//    @Override
//    public Service getService() {
//        return null;
//    }

    @Override
    public void close() {

    }
}
