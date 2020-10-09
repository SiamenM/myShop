package com.maskalenchyk.shop.entity;

public class Producer extends AbstractEntity  {

    private static final long serialVersionUID = -6717946876970540916L;
    private String name;

    public Producer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
