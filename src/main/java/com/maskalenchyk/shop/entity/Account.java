package com.maskalenchyk.shop.entity;

public class Account extends AbstractEntity {
    private static final long serialVersionUID = -4258689637645889092L;
    private String name;
    private String email;

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
