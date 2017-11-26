package com.chatbot.repository;

import com.chatbot.model.Order;
import com.chatbot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,String>{
    public Order findById(String id);
    public List<Order> findByUser(User user);
}
