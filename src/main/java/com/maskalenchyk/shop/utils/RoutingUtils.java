package com.maskalenchyk.shop.utils;

import com.maskalenchyk.shop.application.ApplicationConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class RoutingUtils {

    public static void forwardToFragment(String jspPage, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/fragment/" + jspPage).forward(req, resp);
    }

    public static void forwardToPage(String jspPage, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute(ApplicationConstants.CURRENT_PAGE, "page/" + jspPage);
        req.getRequestDispatcher("/WEB-INF/jsp/page-template.jsp").forward(req, resp);
    }

    public static void redirect(String url, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(url);
    }

    public static void sendHTMLFragment(String text, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println(text);
        resp.getWriter().close();
    }
}
