package com.maskalenchyk.shop.filter;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(value = "/*",filterName = "ErrorHandlerFilter")
public class ErrorHandlerFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(ErrorHandlerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            String requestURI = ((HttpServletRequest) request).getRequestURI();
            LOGGER.error("Request " + requestURI + " failed: " + e.getMessage(), e);
            request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
