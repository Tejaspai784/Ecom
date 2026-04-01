package com.ecommerce.order.controller;

import com.ecommerce.order.model.Cart;
import com.ecommerce.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public Cart getCart(@PathVariable String userId) {
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/{userId}/items")
    public String addItemToCart(@PathVariable String userId, @RequestParam String sku, @RequestParam Integer quantity) {
        // Logic for adding items (CartItemDTO) would go here
        return "Item added to cart for user: " + userId;
    }

    @DeleteMapping("/{userId}")
    public void clearCart(@PathVariable String userId) {
        cartService.clearCart(userId);
    }
}