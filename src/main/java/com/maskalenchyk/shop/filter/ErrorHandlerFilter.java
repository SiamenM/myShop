package com.maskalenchyk.shop.filter;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "ErrorHandlerFilter")
public class ErrorHandlerFilter extends AbstractFilter {


    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) {
        try {
            chain.doFilter(req, resp);
        } catch (Exception e) {
            String requestURI = req.getRequestURI();
            LOGGER.error("Request " + requestURI + " failed: " + e.getMessage(), e);
            req.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
    }

}
