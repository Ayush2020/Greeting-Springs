package com.Capgemini.GreetingSprings.Controller;

import com.Capgemini.GreetingSprings.Entity.Greeting;
import com.Capgemini.GreetingSprings.Service.GreetingService;
import com.Capgemini.GreetingSprings.Service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController extends ServiceLayer {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.OK);
    }

    @PostMapping("/greeting/{name}")
    public ResponseEntity<String> postGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(greetingService.postMessage(new Greeting(name)).getMessage(), HttpStatus.OK);
    }

    @PutMapping("/greeting/put/{name}")
    public ResponseEntity<String> putGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Update, %s", name), HttpStatus.OK);
    }

    @DeleteMapping("/greeting/delete/{name}")
    public ResponseEntity<String> deleteGreeting(@PathVariable("name") String name){
        return new ResponseEntity<>(String.format("Delete, %s", name), HttpStatus.OK);
    }

    @GetMapping("greeting2")
    public ResponseEntity<String> greetings
            (@RequestParam(value = "firstName", defaultValue = "Hello") String firstName
                    , @RequestParam(value = "lastName", defaultValue = "World") String lastName){
        return new ResponseEntity<>(firstName + " " + lastName, HttpStatus.OK);
    }

    
    @GetMapping("greeting/get/{id}")
    public ResponseEntity<String> greetings(@PathVariable Long id){
        return new ResponseEntity<>(greetingService.getMessage(id), HttpStatus.OK);
    }
    @GetMapping("/greeting/all")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        return new ResponseEntity<>(greetingService.getAllMessages(), HttpStatus.OK);
    }
    @PutMapping("/greeting/edit/{id}")
    public ResponseEntity<String> updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return new ResponseEntity<>("Updated Greeting: " + greetingService.updateMessage(id, updatedGreeting.getMessage()).getMessage(), HttpStatus.OK);
    }
}