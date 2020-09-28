package com.maskalenchyk.shop.application;

public final class ApplicationConstants {

    public static final String CURRENT_SHOPPING_CART = "CURRENT_SHOPPING_CART";
    public static final String CURRENT_PAGE = "CURRENT_PAGE";

    public static final int MAX_PRODUCT_COUNT_PER_SHOPPING_CART = 10;
    public static final int MAX_PRODUCTS_PER_SHOPPING_CART = 20;

    public enum Cookie{
        SHOOPING_CART("shoppingCart",60*60*24*365);

        private final String name;
        private final int lifeTime;

        Cookie(String name, int lifeTime) {
            this.name = name;
            this.lifeTime = lifeTime;
        }

        public String getName() {
            return name;
        }

        public int getLifeTime() {
            return lifeTime;
        }
    }
}
