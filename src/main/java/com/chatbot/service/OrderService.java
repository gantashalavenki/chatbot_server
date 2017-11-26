package com.chatbot.service;


import com.chatbot.model.Cart;
import com.chatbot.model.Order;
import com.chatbot.model.User;
import com.chatbot.repository.OrderRepository;
import com.chatbot.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

  @Autowired
  private CartService cartService;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private UserService userService;

  public String placeOrder(String cartId, String address){
      Cart cart =  cartService.getCart(cartId);
      Order order = new Order();
      order.setCart(cart);
      order.setAddress(address);
      order.setUser(cart.getUser());
      order.setStatus(Constants.ORDER_STATUS_PLACED);
      cart.setActive(false);
      cartService.save(cart);
      orderRepository.save(order);
      return Constants.SUCCESS;
  }

  public String changeStatus(String orderItemId, String status){
      Order order = orderRepository.findById(orderItemId);
      order.setStatus(status);
      orderRepository.save(order);
      return Constants.SUCCESS;
  }
  public String getStatus(String orderId){
      Order order = orderRepository.findById(orderId);
      if(order == null){
          return "Order doesn't exist";
      }
      return order.getStatus();
  }

  public List<Order> getOrders(String userId){
      User user = userService.getUSerById(userId);
      return orderRepository.findByUser(user);
  }

}
