package com.ecommerce.order.service.impl;

import com.ecommerce.order.model.Cart;
import com.ecommerce.order.repository.CartRepository;
import com.ecommerce.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> createCartForUser(userId)); // Create if doesn't exist
    }

    @Override
    public Cart createCartForUser(String userId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setLastUpdated(new Date());
        return cartRepository.save(cart);
    }

    @Override
    public void clearCart(String userId) {
        cartRepository.findByUserId(userId).ifPresent(cart -> {
            cartRepository.delete(cart);
        });
    }
}