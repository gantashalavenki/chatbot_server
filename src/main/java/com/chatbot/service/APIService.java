package com.chatbot.service;

import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.AIServiceException;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import com.chatbot.util.Constants;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class APIService {

    AIConfiguration aiConfiguration =  new AIConfiguration(Constants.API_AI_ACCESS_ID);


    public Map<String, JsonElement> analyseText(String text){
        AIDataService dataService = new AIDataService(aiConfiguration);

        AIRequest request = new AIRequest(text);
        AIResponse response = null;
        try {
            response = dataService.request(request);

        } catch (AIServiceException e) {
            e.printStackTrace();
        }
        return response.getResult().getParameters();
    }

}
