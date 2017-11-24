package com.chatbot.repository;

import com.chatbot.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,String>{
    public Order findById(String id);
}
