package com.chatbot.controller;

import com.chatbot.model.Cart;
import com.chatbot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String addProduct(@RequestParam String userId, @RequestParam String productId) {
         return cartService.addProduct(userId,productId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Cart getCart(@RequestParam String userId){
        return cartService.getCartByUser(userId);
    }


    @RequestMapping(value = "/remove-cart-item",method = RequestMethod.POST)
    public String removeCartItem(@RequestParam String cartId, @RequestParam String cartItemId){
     return cartService.removeCartItem(cartId,cartItemId);
    }
}
