package com.ecommerce.order.controller;

import com.ecommerce.order.model.Order;
import com.ecommerce.order.service.impl.OrderManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderManagerService orderService; // Pointing to the INTERFACE

    @PostMapping("/create")
    public Order createOrder(@RequestParam String userId) {
        return orderService.createOrder(userId, new ArrayList<>());
    }

    @PostMapping("/add-item")
    public String addItem(@RequestBody CartItemDTO itemDto) {
    // Logic: use itemDto.getSku() and itemDto.getQuantity()
    return "Added to cart";
    }
}