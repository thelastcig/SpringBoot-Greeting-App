package com.greetings_app.greeting_app;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.greetings_app.model.Greeting;
import com.greetings_app.service.GreetingService;

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

    //UC-2 Extend GreetingController to use Services Layer to get Simple Greeting message ”Hello World”
    private final GreetingService greetingService;
    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    @GetMapping("/simple")
    public String getSimpleGreeting(){
        return greetingService.getSimpleGreeting();
    }

    //UC-3 Ability for the Greeting App to give Greeting message

    @GetMapping("/personalized")
    public String getPersonalizedString(
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName){

      return greetingService.getPersonalizedGreeting(firstName, lastName);
    }

    //UC-4 Ability for the Greeting App to save the Greeting Message in the Repository
    //To verify stored greetings, open H2 Console in your browser:
    //http://localhost:8080/h2-console
    //JDBC URL: jdbc:h2:mem:greetingsdb
    //Username: sa
    //Password: (leave empty)
    @GetMapping("/personalized/save")
    public String getPersonalizedGreeting(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreetings(firstName, lastName);
    }

    //UC-5 Ability for the Greeting App to find a Greeting Message by Id in the Repository
    
    //First Save the id http://localhost:8080/greetings/personalized/save?firstName=sonu&lastName=sharma
    //then http://localhost:8080/greetings/1

    @GetMapping("/{id}")
    public Optional<Greeting> getGreetingById(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    //UC-6 Ability for the Greeting App to List all the Greeting Messages    
    //http://localhost:8080/greetings/all
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    //UC-7 Ability for the Greeting App to Edit a Greeting Messages in the Repository
    //curl -X PUT "http://localhost:8080/greetings/edit/2" --data-urlencode "message=Hello, Aryaman Sharma!"    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateGreeting(@PathVariable Long id, @RequestParam String message) {
        Optional<Greeting> updatedGreeting = greetingService.updateGreeting(id, message);
        return updatedGreeting
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
   
    
}
