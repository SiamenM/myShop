package com.maskalenchyk.shop.servlet;

import com.maskalenchyk.shop.utils.RoutingUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class ErrorController extends AbstractController {
    private static final long serialVersionUID = -8779236526628240132L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoutingUtils.forwardToPage("error.jsp", req, resp);
    }
}
