package com.ecommerce.order.service.impl;

import com.ecommerce.order.model.Cart;
import com.ecommerce.order.repository.CartRepository;
import com.ecommerce.order.service.CartService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

  @Autowired private CartRepository cartRepository;
  private CartItemRepository cartItemRepository;

  @Override
  public Cart getCartByUserId(String userId) {
    return cartRepository.findByUserId(userId).orElseGet(() -> createCartForUser(userId));
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
    cartRepository
        .findByUserId(userId)
        .ifPresent(
            cart -> {
              cartRepository.delete(cart);
            });
  }

  @Override
  @Transactional
  public void addToCart(String userId, CartItemDTO itemDto) {
    Cart cart = getCartByUserId(userId);
    Optional<CartItem> existingItem =
        cartItemRepository.findByCartIdAndSku(cart.getId(), itemDto.getSku());

    if (existingItem.isPresent()) {
      CartItem item = existingItem.get();
      item.setQuantity(item.getQuantity() + itemDto.getQuantity());
      cartItemRepository.save(item);
    } else {
      CartItem newItem = new CartItem();
      newItem.setCartId(cart.getId());
      newItem.setSku(itemDto.getSku());
      newItem.setQuantity(itemDto.getQuantity());
      cartItemRepository.save(newItem);
    }
  }
}
