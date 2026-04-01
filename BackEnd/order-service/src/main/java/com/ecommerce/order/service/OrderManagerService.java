package com.ecommerce.order.service;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderItem;
import java.util.List;

public interface OrderManagerService {
    Order createOrder(String userId, List<OrderItem> items);
    Order getOrderById(Long orderId);
}