package com.Capgemini.GreetingSprings.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new ResponseEntity<>(String.format("Hello, %s", name), HttpStatus.OK);
    }
}
