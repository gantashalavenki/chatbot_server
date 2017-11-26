package com.chatbot.service;

import com.chatbot.model.User;
import com.chatbot.repository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserMongoRepository userMongoRepository;

   public User register(String name, String facebookId){
      User user = userMongoRepository.findByFacebookId(facebookId);
      if(user == null){
          user = new User(name,facebookId);
      } else {
          user.setName(name);
      }
       userMongoRepository.save(user);
      return user;
   }

   public User getUSerById(String userId){
       return userMongoRepository.findById(userId);
   }
}
