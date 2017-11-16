package com.chatbot.controller;

import com.chatbot.model.Product;
import com.chatbot.repository.CategoryRepository;
import com.chatbot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String add(@RequestParam String category, @RequestParam String name, @RequestParam String imagePath){
      productService.addProduct(category,name,imagePath);
      return "Success";
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Product> get(@RequestParam String category){
      return productService.getByCategory(category);
    }

}
