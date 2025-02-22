package com.greetings_app.greeting_app;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    //UC-1 Using GreetingController return JSON for different HTTP Methods.
    @GetMapping
    public String getGreeting(){
        return  "{\"message\": \"Hello, GET request received!\"}";
    }

    @PostMapping
    public String postGreeting(){
        return  "{\"message\": \"Hello, POST request received!\"}";
    }

    @PutMapping
    public String putGreeting(){
        return  "{\"message\": \"Hello, PUT request received!\"}";
    }

    @DeleteMapping
    public String deleteGreeting(){
        return  "{\"message\": \"Hello, DELETE request received!\"}";
    }
    //curl -X GET http://localhost:8080/greetings/display
    @GetMapping("/display") 
    public Map<String, String> map(){
        return Map.of(
            "Get: ", getGreeting(),
            "POST: ", postGreeting(),
            "PUT: ", putGreeting(),
            "DELETE: ", deleteGreeting()
        );
    }
    
}
