package com.chatbot.controller;

import com.chatbot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/place", method = RequestMethod.POST)
    public String placeOrder(@RequestParam String cartId, @RequestParam String address){
      return orderService.placeOrder(cartId,address);
    }

    @RequestMapping(value = "/status-change", method = RequestMethod.POST)
    public String changeStatus(@RequestParam String orderItemId, @RequestParam String status){
       return orderService.changeStatus(orderItemId,status);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public Object getStatus(String orderId){
       return orderService.getStatus(orderId);
    }

}
