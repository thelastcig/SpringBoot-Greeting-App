package com.greetings_app.service;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;
import com.greetings_app.model.Greeting;
import com.greetings_app.repository.GreetingRepository;

@Service
public class GreetingService {
    //UC-2
    public String getSimpleGreeting(){
        return "{\"greetings\": \"Hello World\"}";
    }    
    //UC-3
    public String getPersonalizedGreeting(String firstName, String lastName){
        if(firstName != null && lastName != null){
            return "{\"message\": \"Hello, " + firstName + " " + lastName + "!\"}";
        }else if(firstName != null){
            return "{\"message\": \"Hello, " + firstName + "!\"}";
        }else if(lastName != null){
            return "{\"message\": \"Hello, " + lastName + "!\"}";
        }else{
            return "{\"message\": \"Hello World\"}";
        }
    }

    //UC-4

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public String getPersonalizedGreetings(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello, " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello, " + lastName + "!";
        } else {
            message = "Hello World";
        }

        saveGreeting(message);
        return "{\"message\": \"" + message + "\"}";
    }
    
    //UC -5
    public Optional<Greeting> findGreetingById(Long id) {
        return greetingRepository.findById(id);
    }

    //UC-6
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    //UC-7
    public Optional<Greeting> updateGreeting(Long id, String newMessage) {
        Optional<Greeting> existingGreeting = greetingRepository.findById(id);
        if (existingGreeting.isPresent()) {
            Greeting greeting = existingGreeting.get();
            greeting.setMessage(newMessage);
            return Optional.of(greetingRepository.save(greeting));
        }
        return Optional.empty();
    }

    //UC-8
    public boolean deleteGreeting(Long id) {
        if (greetingRepository.existsById(id)) {
            greetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
