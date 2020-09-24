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

    }

    protected void sync(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(!SessionUtils.isCurrentShoppingCartCreated(request)){
            Cookie cookie = SessionUtils.f
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
            try{
                Integer idProduct = Integer.parseInt(data[0]);
                Integer count = Integer.parseInt(data[1]);
                shoppingCart.addProduct(idProduct,count);
            }catch (RuntimeException e){
                //handleException
                e.printStackTrace();
            }
        }
        return shoppingCart;
    }
}
