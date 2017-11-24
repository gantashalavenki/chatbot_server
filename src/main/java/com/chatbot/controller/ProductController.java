package com.chatbot.controller;

import com.chatbot.model.Product;
import com.chatbot.repository.CategoryRepository;
import com.chatbot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String add(@RequestParam String category, @RequestParam String name, @RequestParam BigInteger price, @RequestParam String imagePath){
      productService.addProduct(category,name,price,imagePath);
      return "Success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Product> get(@RequestParam String category){
      return productService.getByCategory(category);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("productId") String productId){
      return productService.getProduct(productId);
    }
}
