package com.maskalenchyk.shop.model;

import com.maskalenchyk.shop.application.ApplicationConstants;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = -1193300041398345614L;
    private Map<Integer, ShoppingCartItem> products = new HashMap<>();
    private int totalCount = 0;

    public void addProduct(Integer idProduct, Integer count) {
        validateShoppingCartSize(idProduct);
        ShoppingCartItem shoppingCartItem = products.get(idProduct);
        if (shoppingCartItem == null) {
            validateProductCount(count);
            shoppingCartItem = new ShoppingCartItem(idProduct, count);
            products.put(idProduct, shoppingCartItem);
        } else {
            validateProductCount(count + shoppingCartItem.getCount());
            shoppingCartItem.setCount(shoppingCartItem.getCount() + count);
        }
        refreshStatistics();
    }

    public void removeProduct(Integer idProduct, Integer count) {
        ShoppingCartItem shoppingCartItem = products.get(idProduct);
        if (shoppingCartItem != null) {
            if (shoppingCartItem.getCount() > count) {
                shoppingCartItem.setCount(shoppingCartItem.getCount() - count);
            } else {
                products.remove(idProduct);
            }
            refreshStatistics();
        }
    }

    private void refreshStatistics() {
        totalCount = 0;
        for (ShoppingCartItem shoppingCartItem : getItems()) {
            totalCount += shoppingCartItem.getCount();
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public Collection<ShoppingCartItem> getItems() {
        return products.values();
    }

    private void validateProductCount(Integer count) {
        if (products.size() > ApplicationConstants.MAX_PRODUCT_COUNT_PER_SHOPPING_CART) {
            throw new ShoppingCartValidationException("Limit for product count reached: count=" + count);
        }
    }

    private void validateShoppingCartSize(Integer idProduct) {
        if (products.size() > ApplicationConstants.MAX_PRODUCTS_PER_SHOPPING_CART ||
                (products.size() == ApplicationConstants.MAX_PRODUCTS_PER_SHOPPING_CART && !products.containsKey(idProduct))) {
            throw new ShoppingCartValidationException("Limit for shopping cart size reached: size=" + products.size());
        }
    }

    @Override
    public String toString() {
        return String.format("ShoppingCart [products=%s, totalCount=%s]", products, totalCount);
    }
}
