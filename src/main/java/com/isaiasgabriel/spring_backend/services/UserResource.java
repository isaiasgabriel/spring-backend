package com.isaiasgabriel.spring_backend.services;

import com.isaiasgabriel.spring_backend.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users") // request at localhost/users
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Maria", "maria@gmail.com","maria123" ,"4599999-9999");
        return ResponseEntity.ok().body(user);
    }
}
