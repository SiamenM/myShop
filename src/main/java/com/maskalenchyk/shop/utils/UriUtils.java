package com.maskalenchyk.shop.utils;

public final class UriUtils {

    private UriUtils() {
    }

    public static boolean isAjaxUri(String uri) {
        return uri.startsWith("/ajax/");
    }

    public static boolean isAjaxJsonUri(String uri) {
        return uri.startsWith("/ajax/json/");
    }

    public static boolean isAjaxHtmlUri(String uri) {
        return uri.startsWith("/ajax/html/");
    }

    public static boolean isStaticUri(String uri) {
        return uri.startsWith("/static/");
    }

    public static boolean isMediaUri(String uri) {
        return uri.startsWith("/media/");
    }
}
