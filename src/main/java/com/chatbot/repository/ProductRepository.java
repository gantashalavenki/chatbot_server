package com.chatbot.repository;

import com.chatbot.model.Category;
import com.chatbot.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

    List<Product> findByCategory(Category category);
    Product findById(String id);
}
