package com.chatbot.service;

import com.chatbot.model.Category;
import com.chatbot.model.Product;
import com.chatbot.repository.CategoryRepository;
import com.chatbot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

   public void addProduct(String categoryName, String name, String imagePath){
     Category category = categoryRepository.findByName(categoryName);
     if(category == null){
         category =  new Category();
         category.setName(categoryName);
         categoryRepository.insert(category);
     }
       Product product = new Product();
     product.setCategory(category);
     product.setName(name);
     product.setImage(imagePath);
     productRepository.insert(product);
   }

   public List<Product> getAll(){
    return productRepository.findAll();
   }


   public List<Product> getByCategory(String categoryName){
       Category category = categoryRepository.findByName(categoryName);
       if(category ==  null){
           return null;
       }
       return productRepository.findByCategory(category);
   }
}
