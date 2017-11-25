package com.chatbot.controller;


import com.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public String register (@RequestParam String name, @RequestParam String facebookId){
      return userService.register(name,facebookId).getId();
    }


}
