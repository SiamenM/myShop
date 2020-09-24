package com.maskalenchyk.shop.servlet;

import com.maskalenchyk.shop.model.ShoppingCart;
import com.maskalenchyk.shop.model.ShoppingCartItem;
import com.maskalenchyk.shop.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shopping-cart")
public class ShoppingCartServlet extends HttpServlet {
    private static final long serialVersionUID = -6404544570764612144L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cmd = req.getParameter("cmd");
        switch (cmd) {
            case "clear":
                SessionUtils.clearCurrentShoppingCart(req, resp);
                break;
            case "invalidate":
                req.getSession().invalidate();
                break;
            case "add":
                addProduct(req, resp);
                break;
            default:
                sync(req, resp);
        }

    }

    protected void sync(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (SessionUtils.isCurrentShoppingCartCreated(request)) {
            ShoppingCart shoppingCart = SessionUtils.getCurrentShopppingCart(request);
            String cookieValue = shoppingCartToString(shoppingCart);
            SessionUtils.updateCurrentShoppingCartCookie(cookieValue, response);
        } else {
            Cookie cookie = SessionUtils.findShoppingCartCookie(request);
            if (cookie != null) {
                ShoppingCart shoppingCart = shoppingCartFromString(cookie.getValue());
                SessionUtils.setCurrentShoppingCart(request, shoppingCart);

            }
        }
    }

    protected String shoppingCartToString(ShoppingCart shoppingCart) {
        StringBuilder stringBuilder = new StringBuilder();
        for (ShoppingCartItem shoppingCartItem : shoppingCart.getItems()) {
            stringBuilder.append(shoppingCartItem.getIdProduct()).append("-").append(shoppingCartItem.getCount()).append("|");
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return shoppingCart.toString();
    }

    protected ShoppingCart shoppingCartFromString(String cookieValue) {
        ShoppingCart shoppingCart = new ShoppingCart();
        String[] items = cookieValue.split("\\|");
        for (String item : items) {
            String data[] = item.split("-");
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

    protected void addProduct(HttpServletRequest request, HttpServletResponse response) {
        ShoppingCart shoppingCart = SessionUtils.getCurrentShopppingCart(request);
        shoppingCart.addProduct(5, 5);
    }
}
