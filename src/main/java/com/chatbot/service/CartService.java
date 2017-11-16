package com.chatbot.service;

import com.chatbot.model.Cart;
import com.chatbot.model.Product;
import com.chatbot.model.User;
import com.chatbot.repository.CartRepository;
import com.chatbot.repository.ProductRepository;
import com.chatbot.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private UserMongoRepository userMongoRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartRepository cartRepository;

    public String addProduct(String userId, String productId){
        User user =  userMongoRepository.findById(userId);
        if(user == null){
            return "User doesn't Exist";
        }
        Product product = productRepository.findById(productId);
        if(product == null){
            return "product doesn't Exist";
        }
        Cart cart =  cartRepository.findByUserAndIsActive(user,true);
        if(cart == null){
            cart =  new Cart();
            cart.setActive(true);
            cart.setUser(user);
        }
        cart.addProduct(product);
        cartRepository.save(cart);
        return "success";
    }

    public Cart getCart(String cartId){
        return cartRepository.findById(cartId);
    }
}
