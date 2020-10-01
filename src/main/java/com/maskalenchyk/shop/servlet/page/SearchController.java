package com.maskalenchyk.shop.servlet.page;

import com.maskalenchyk.shop.servlet.AbstractController;
import com.maskalenchyk.shop.utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchController extends AbstractController {
    private static final long serialVersionUID = 4348218745494214447L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productCount", 1);
        RoutingUtils.forwardToPage("search-result.jsp", req, resp);
    }
}
