package com.maskalenchyk.shop.application;

public final class ApplicationConstants {

    public static final String CURRENT_SHOPING_CART = "CURRENT_SHOPING_CART";

    public static final int MAX_PRODUCT_COUNT_PER_SHOPING_CART = 10;
    public static final int MAX_PRODUCTS_PER_SHOPING_CART = 20;

    public enum Cookie{
        SHOOPING_CART("iSCC",60*60*24*365);

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
