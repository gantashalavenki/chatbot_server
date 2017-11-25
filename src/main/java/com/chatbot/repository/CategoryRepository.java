package com.chatbot.repository;

import com.chatbot.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByNameIgnoreCase(String name);
}
