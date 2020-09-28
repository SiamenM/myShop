package com.maskalenchyk.shop.servlet;

import com.maskalenchyk.shop.service.ServiceManager;
import com.maskalenchyk.shop.service.ServiceManagerImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AbstractController extends HttpServlet {
    private static final long serialVersionUID = -930818253786574890L;
    private ServiceManager serviceManager;

    @Override
    public final void init() throws ServletException {
        this.serviceManager = ServiceManagerImpl.getInstance(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public final void destroy() {
        this.serviceManager = null;
    }
}
