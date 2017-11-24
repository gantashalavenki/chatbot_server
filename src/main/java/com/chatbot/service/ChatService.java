package com.chatbot.service;

import com.amazonaws.services.dynamodbv2.xspec.S;
import com.chatbot.model.Cart;
import com.chatbot.model.Product;
import com.chatbot.util.API_INTENT;
import com.chatbot.util.Constants;
import com.google.gson.JsonElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    @Autowired
    private APIService apiService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    public Map<String, Object> analyzeText(String text, String userId) {
        Map<String, JsonElement> response = apiService.analyseText(text);
        return handleResponse(response,userId);
    }

    public Map<String, Object> handleResponse(Map<String, JsonElement> response, String userId) {
        String intent = response.get(Constants.INTENT_NAME).getAsString();
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put(Constants.INTENT_NAME, intent);
        switch (intent) {
            case API_INTENT.ORDER_STATUS:
            case API_INTENT.SHIPPING_STATUS:
                String orderId = response.get(Constants.API_AI_ORDER_ID).getAsString();
                responseMap.put(Constants.ORDER_STATUS, orderService.getStatus(orderId));
                break;
            case API_INTENT.PRODUCT_FIND:
                String query = response.get(Constants.API_AI_PRODUCT_NAME).getAsString();
                List<Product> productList = productService.getProductsByNameOrCategory(query);
                responseMap.put(Constants.PRODUCT_LIST,productList);
                break;
            case API_INTENT.CART_VIEW:
                Cart cart  = cartService.getCartByUser(userId);
                responseMap.put("cart",cart);
            default:
        }

        return responseMap;
    }

}
