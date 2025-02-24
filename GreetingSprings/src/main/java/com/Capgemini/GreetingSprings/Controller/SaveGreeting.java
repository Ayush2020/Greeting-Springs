package com.Capgemini.GreetingSprings.Controller;


import com.Capgemini.GreetingSprings.Entity.Greeting;
import com.Capgemini.GreetingSprings.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveGreeting {

    @Autowired
    private GreetingService greetingService;

    @Autowired
    public SaveGreeting(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    @PostMapping
    public ResponseEntity<Greeting> postGreeting(String message){
        Greeting greeting = greetingService.postMessage(new Greeting(message));
        return new ResponseEntity<>(greeting, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<String> postGreeting(Long id){
        return new ResponseEntity<>(greetingService.getMessage(id), HttpStatus.CREATED);
    }

}