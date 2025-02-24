package com.Capgemini.GreetingSprings.Repository;


import com.Capgemini.GreetingSprings.Entity.Greeting;
import org.springframework.data.repository.CrudRepository;

public interface GreetingRepo extends CrudRepository<Greeting, Long> {
}
