package com.maskalenchyk.shop.entity;

import java.math.BigDecimal;
import java.util.StringJoiner;

public class Product extends AbstractEntity {
    private static final long serialVersionUID = 8637500189112849359L;
    private String name;
    private String description;
    private Category category;
    private Producer producer;
    private ProductImage productImage;
    private BigDecimal price;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("category=" + category)
                .add("producer=" + producer)
                .add("productImage=" + productImage)
                .add("price=" + price)
                .add("id=" + id)
                .toString();
    }
}
