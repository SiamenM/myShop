package com.maskalenchyk.shop.utils;

import com.maskalenchyk.shop.application.ApplicationConstants;
import com.maskalenchyk.shop.model.ShoppingCart;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {

    private SessionUtils() {

    }

    public static ShoppingCart getCurrentShopppingCart(HttpServletRequest request) {
        ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(ApplicationConstants.CURRENT_SHOPPING_CART);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            request.getSession().setAttribute(ApplicationConstants.CURRENT_SHOPPING_CART, shoppingCart);
        }
        return shoppingCart;
    }

    public static boolean isCurrentShoppingCartCreated(HttpServletRequest request) {
        return request.getSession().getAttribute(ApplicationConstants.CURRENT_SHOPPING_CART) != null;
    }
}
