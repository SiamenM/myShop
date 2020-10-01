package com.maskalenchyk.shop.servlet.ajax;

import com.maskalenchyk.shop.servlet.AbstractController;
import com.maskalenchyk.shop.utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax/html/more/products/*")
public class ProductsByCategoryMoreController extends AbstractController {
    private static final long serialVersionUID = -8652667788210660980L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer substringIndex = "/products".length();
        String categoryUrl = req.getRequestURI().substring(substringIndex);
        RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
    }
}
