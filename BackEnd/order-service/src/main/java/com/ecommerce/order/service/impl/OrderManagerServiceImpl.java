package com.ecommerce.order.service.impl;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderItem;
import com.ecommerce.order.repository.OrderItemRepository;
import com.ecommerce.order.repository.OrderRepository;
import com.ecommerce.order.service.OrderManagerService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderManagerServiceImpl implements OrderManagerService {

  @Autowired private OrderRepository orderRepository;

  @Autowired private OrderItemRepository orderItemRepository;

  @Override
  @Transactional
  public Order createOrder(String userId, List<OrderItem> items) {
    // 1. Calculate the total price of all items
    BigDecimal total =
        items.stream()
            .map(item -> item.getUnitPrice().multiply(new BigDecimal(item.getQuantity())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

    // 2. Create the main Order (The Header)
    Order order = new Order();
    order.setUserId(userId);
    order.setTotalAmount(total);
    order.setStatus("PENDING");

    // Save using orderRepository
    Order savedOrder = orderRepository.save(order);

    // 3. Save each individual item (The Lines)
    for (OrderItem item : items) {
      item.setOrderId(Objects.requireNonNull(savedOrder.getId()).toString());

      // FIX FOR LINE 38: Use orderItemRepository, NOT orderRepository
      orderItemRepository.save(item);
    }

    return savedOrder;
  }

  @Override
  public Order getOrderById(Long orderId) {
    return orderRepository
        .findById(Objects.requireNonNull(orderId))
        .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
  }
}
