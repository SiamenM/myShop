package com.maskalenchyk.shop.filter;

import com.maskalenchyk.shop.model.ShoppingCart;
import com.maskalenchyk.shop.utils.SessionUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AutoRestoreShoppingCartFilter")
public class AutoRestoreShoppingCartFilter extends AbstractFilter {
    private static final String SHOPPING_CART_DESERIALIZATION_DONE = "SHOPPING_CART_DESERIALIZATION_DONE";

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute(SHOPPING_CART_DESERIALIZATION_DONE) == null) {
            if (!SessionUtils.isCurrentShoppingCartCreated(req)) {
                Cookie cookie = SessionUtils.findShoppingCartCookie(req);
                if (cookie != null) {
                    ShoppingCart shoppingCart = shoppingCartFromString(cookie.getValue());
                    SessionUtils.setCurrentShoppingCart(req, shoppingCart);
                }
            }
            req.getSession().setAttribute(SHOPPING_CART_DESERIALIZATION_DONE, Boolean.TRUE);
        }
        chain.doFilter(req, resp);
    }

    private ShoppingCart shoppingCartFromString(String cookieValue) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = cookieValue.split("\\|");
        for (String item : items) {
            String[] data = item.split("-");
            try {
                Integer idProduct = Integer.parseInt(data[0]);
                Integer count = Integer.parseInt(data[1]);
                shoppingCart.addProduct(idProduct, count);
            } catch (RuntimeException e) {
                //handleException
                e.printStackTrace();
            }
        }
        return shoppingCart;
    }

}
