package com.ecommerce.order.service;
import com.ecommerce.common.dto.CartItemDTO;
import com.ecommerce.order.model.Cart;

public interface CartService {
    Cart getCartByUserId(String userId);
    Cart createCartForUser(String userId);
    void clearCart(String userId);
    void addToCart(String userId, CartItemDTO itemDto);
}