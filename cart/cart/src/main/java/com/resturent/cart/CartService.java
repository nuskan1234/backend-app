package com.resturent.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart addToCart(Cart cartItem) {
        // Check if the item already exists in the cart
        Optional<Cart> existingItem = cartRepository.findById(cartItem.getId());
        if (existingItem.isPresent()) {
            // If item exists, update its quantity
            Cart currentItem = existingItem.get();
            currentItem.setQuantity(currentItem.getQuantity() + cartItem.getQuantity());
            return cartRepository.save(currentItem);
        } else {
            // If item doesn't exist, add it to the cart
            return cartRepository.save(cartItem);
        }
    }

    public Cart getCartById(int cartId) {
        // Retrieve cart item by cartId
        Optional<Cart> cartItem = cartRepository.findById(cartId);
        return cartItem.orElse(null);
    }

    public Cart getCartByUserId(int userId) {
        // Retrieve cart items by userId
        return cartRepository.findByUserId(userId);
    }

    public Cart updateCart(int cartId, Cart cartItem) {
        // Update cart item details
        if (cartRepository.existsById(cartId)) {
            cartItem.setId(cartId); // Ensure consistency between path variable and request body
            return cartRepository.save(cartItem);
        } else {
            return null; // Cart item with given ID not found
        }
    }

    public void clearCart(int cartId) {
        // Delete cart item by cartId
        cartRepository.deleteById(cartId);
    }
}
