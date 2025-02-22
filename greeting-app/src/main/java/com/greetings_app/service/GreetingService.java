package com.greetings_app.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getSimpleGreeting(){
        return "{\"greetings\": \"Hello World\"}";
    }    
}
