package com.resturent.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public Cart addToCart(@RequestBody Cart cartItem) {
        // Implement logic to add item to cart
        return cartService.addToCart(cartItem);
    }

    @GetMapping("/{cartId}")
    public Cart getCartDetails(@PathVariable int cartId) {
        // Implement logic to retrieve cart details by cartId
        return cartService.getCartById(cartId);
    }

    @GetMapping("/user/{userId}")
    public Cart getCartByUserId(@PathVariable int userId) {
        // Implement logic to retrieve cart details by userId
        return cartService.getCartByUserId(userId);
    }

    @PutMapping("/{cartId}")
    public Cart updateCart(@PathVariable int cartId, @RequestBody Cart cartItem) {
        // Implement logic to update cart (e.g., update item quantities)
        return cartService.updateCart(cartId, cartItem);
    }

    @DeleteMapping("/{cartId}")
    public void clearCart(@PathVariable int cartId) {
        // Implement logic to clear the cart
        cartService.clearCart(cartId);
    }
}
