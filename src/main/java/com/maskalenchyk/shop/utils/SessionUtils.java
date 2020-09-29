package com.maskalenchyk.shop.utils;

import com.maskalenchyk.shop.ApplicationConstants;
import com.maskalenchyk.shop.model.ShoppingCart;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionUtils {

    private SessionUtils() {

    }


    public static ShoppingCart getCurrentShopppingCart(HttpServletRequest request) {
        ShoppingCart shoppingCart = (ShoppingCart) request.getSession().getAttribute(ApplicationConstants.CURRENT_SHOPPING_CART);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            setCurrentShoppingCart(request, shoppingCart);
        }
        return shoppingCart;
    }

    public static void setCurrentShoppingCart(HttpServletRequest request, ShoppingCart shoppingCart) {
        request.getSession().setAttribute(ApplicationConstants.CURRENT_SHOPPING_CART, shoppingCart);
    }

    public static boolean isCurrentShoppingCartCreated(HttpServletRequest request) {
        return request.getSession().getAttribute(ApplicationConstants.CURRENT_SHOPPING_CART) != null;
    }

    public static void clearCurrentShoppingCart(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute(ApplicationConstants.CURRENT_SHOPPING_CART);
        ApplicationUtils.setCookie(ApplicationConstants.Cookie.SHOOPING_CART.getName(), null, 0, response);
    }

    public static void updateCurrentShoppingCartCookie(String cookieValue, HttpServletResponse response) {
        ApplicationUtils.setCookie(ApplicationConstants.Cookie.SHOOPING_CART.getName(), cookieValue,
                ApplicationConstants.Cookie.SHOOPING_CART.getLifeTime(), response);
    }

    public static Cookie findShoppingCartCookie(HttpServletRequest request) {
        return ApplicationUtils.findCookie(request, ApplicationConstants.Cookie.SHOOPING_CART.getName());
    }
}
