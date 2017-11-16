package com.chatbot.repository;

import com.chatbot.model.Cart;
import com.chatbot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart,String>{
    public Cart findByUserAndIsActive(User user, boolean isActive);
    public Cart findById(String id);
}
