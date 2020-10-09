package com.maskalenchyk.shop.entity;

import java.util.StringJoiner;

public class Category extends AbstractEntity {
    private static final long serialVersionUID = 3776925085883867022L;

    private String name;
    private String url;
    private Integer count;

    public Category() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Category.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("url='" + url + "'")
                .add("count=" + count)
                .add("id=" + id)
                .toString();
    }
}
