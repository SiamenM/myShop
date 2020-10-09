package com.maskalenchyk.shop.entity;

import java.util.List;
import java.util.StringJoiner;

public class Order extends AbstractEntity {
    private static final long serialVersionUID = -7460194279865985148L;

    private Account account;
    private List<OrderItem> items;
    private Long creationDate;

    public Order() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("account=" + account)
                .add("items=" + items)
                .add("creationDate=" + creationDate)
                .add("id=" + id)
                .toString();
    }
}
