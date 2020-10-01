package com.maskalenchyk.shop.servlet.page;

import com.maskalenchyk.shop.servlet.AbstractController;
import com.maskalenchyk.shop.utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/*")
public class ProductsByCategoryController extends AbstractController {
    private static final long serialVersionUID = -7189075837442349655L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer substringIndex = "/products".length();
        String categoryUrl = req.getRequestURI().substring(substringIndex);
        RoutingUtils.forwardToPage("products.jsp", req, resp);
    }
}
