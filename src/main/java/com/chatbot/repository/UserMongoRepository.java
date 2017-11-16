package com.chatbot.repository;

import com.chatbot.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<User, String> {
    User findByName(String name);
    User findById(String id);
}
