package com.maskalenchyk.shop.service;

import com.maskalenchyk.shop.entity.Order;

import java.math.BigDecimal;

public interface OrderService {

    BigDecimal getTotalPrice(Order order);
}
