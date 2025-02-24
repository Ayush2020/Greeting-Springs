package com.Capgemini.GreetingSprings.Service;

import com.Capgemini.GreetingSprings.Entity.Greeting;
import com.Capgemini.GreetingSprings.Repository.GreetingRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {

    private final GreetingRepo greetingRepo;

    public GreetingService(GreetingRepo greetingRepo) {
        this.greetingRepo = greetingRepo;
    }

    public String getMessage(Long id) {
        Optional<Greeting> greeting = greetingRepo.findById(id);
        return greeting.map(Greeting::getMessage).orElse("Greeting not found");
    }

    public Greeting postMessage(Greeting greeting) {
        return greetingRepo.save(greeting);
    }
    public List<Greeting> getAllMessages() {
        return (List<Greeting>) greetingRepo.findAll();
    }
    public Greeting updateMessage(Long id, String newMessage) {
        return greetingRepo.findById(id)
                .map(greeting -> {
                    greeting.setMessage(newMessage);
                    return greetingRepo.save(greeting);
                })
                .orElseThrow(() -> new RuntimeException("Greeting Not Found"));
    }
    public void deleteMessage(Long id) {
        greetingRepo.deleteById(id);
    }
}
