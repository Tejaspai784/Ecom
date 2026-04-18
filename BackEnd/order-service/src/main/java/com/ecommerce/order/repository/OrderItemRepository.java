package com.ecommerce.order.repository;
import com.ecommerce.order.model.Order;
import com.ecommerce.order.model.OrderItem;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<Order> findByOrderId(String orderId);
}