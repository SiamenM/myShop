package com.maskalenchyk.shop.servlet.ajax;

import com.maskalenchyk.shop.servlet.AbstractController;
import com.maskalenchyk.shop.utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ajax/html/more/search")
public class SearchResultMoreController extends AbstractController {
    private static final long serialVersionUID = 2464631494443232798L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoutingUtils.forwardToFragment("product-list.jsp", req, resp);
    }
}
