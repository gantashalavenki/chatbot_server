package com.chatbot.controller;


import com.chatbot.service.APIService;
import com.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @RequestMapping(method = RequestMethod.POST)
    public Object readChat(@RequestParam  String chatText, @RequestParam String userId){
      return chatService.analyzeText(chatText, userId);
    }
}
