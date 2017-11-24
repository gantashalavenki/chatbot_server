package com.chatbot.service;

import com.chatbot.model.Cart;
import com.chatbot.model.CartItem;
import com.chatbot.model.Product;
import com.chatbot.model.User;
import com.chatbot.repository.CartItemRepository;
import com.chatbot.repository.CartRepository;
import com.chatbot.repository.ProductRepository;
import com.chatbot.repository.UserMongoRepository;
import com.chatbot.util.Constants;
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

    @Autowired
    private CartItemRepository cartItemRepository;

    public String addProduct(String userId, String productId) {
        User user = userMongoRepository.findById(userId);
        if (user == null) {
            return "User doesn't Exist";
        }
        Product product = productRepository.findById(productId);
        if (product == null) {
            return "product doesn't Exist";
        }
        Cart cart = cartRepository.findByUserAndIsActive(user, true);
        if (cart == null) {
            cart = new Cart();
            cart.setActive(true);
            cart.setUser(user);
        }
        addProductToTheCart(cart, product);
        cartRepository.save(cart);
        return "success";
    }

    private void addProductToTheCart(Cart cart, Product product) {
        for (CartItem cartItem : cart.getCartItemList()) {
            if (cartItem.getProduct().getId().equals(product.getId())) {
                cartItem.increaseQuantityByOne();
                cartItemRepository.save(cartItem);
                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQunatity(1);
        cart.addcartItem(cartItem);
        cartItemRepository.save(cartItem);
    }

    public Cart getCartByUser(String userId) {
        User user =  userMongoRepository.findById(userId);
        return cartRepository.findByUserAndIsActive(user,true);
    }

    public Cart getCart(String cartId){
       return cartRepository.findById(cartId);
    }

    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    public String removeCartItem(String cartId, String cartItemId) {
        Cart cart = getCart(cartId);
        CartItem cartItem = cartItemRepository.findById(cartItemId);
        cart.getCartItemList().remove(cartItem);
        cartRepository.save(cart);
        cartItemRepository.delete(cartItem);
        return Constants.SUCCESS;
    }
}
