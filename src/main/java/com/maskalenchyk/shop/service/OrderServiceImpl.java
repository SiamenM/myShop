package com.maskalenchyk.shop.service;

import com.maskalenchyk.shop.entity.Order;
import com.maskalenchyk.shop.entity.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public BigDecimal getTotalPrice(Order order) {
        BigDecimal price = BigDecimal.ZERO;
        List<OrderItem> items = order.getItems();
        if (items != null) {
            for (OrderItem item : items) {
                price = price.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getItemCount())));
            }
        }
        return price;

    }
}
