package com.maskalenchyk.shop.entity;

public class OrderItem extends AbstractEntity {
    private static final long serialVersionUID = -4454723049585644612L;
    private Product product;
    Integer itemCount;

    public OrderItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }
}
