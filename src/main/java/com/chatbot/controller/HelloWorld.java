package com.chatbot.controller;

import com.chatbot.model.User;
import com.chatbot.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class HelloWorld {


    @Autowired
    private UserMongoRepository userMongoRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public @ResponseBody String getHello(){
        User u =  new User();
        u.setName("bbadwdabbb");
        userMongoRepository.save(u);
        return "hlloe-"+u.getId()+"-"+userMongoRepository.findAll().get(0).getId();
    }
}
