package com.ecommerce.order.controller;

import com.ecommerce.order.model.Cart;
import com.ecommerce.common.dto.CartItemDTO;
import com.ecommerce.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

  @Autowired private CartService cartService;

  @GetMapping("/{userId}")
  public Cart getCart(@PathVariable String userId) {
    return cartService.getCartByUserId(userId);
  }

  @DeleteMapping("/{userId}")
  public void clearCart(@PathVariable String userId) {
    cartService.clearCart(userId);
  }

  @PostMapping("/{userId}/add-item")
  public String addItem(@PathVariable String userId, @RequestBody CartItemDTO itemDto) {
    cartService.addToCart(userId, itemDto);
    return "Successfully added "
        + itemDto.getQuantity()
        + " of SKU: "
        + itemDto.getSku()
        + " to cart.";
  }
}
