package com.isaiasgabriel.spring_backend.resources;

import com.isaiasgabriel.spring_backend.entities.User;
import com.isaiasgabriel.spring_backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/users") // request at localhost/users
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> usersList = service.findAll();
        return ResponseEntity.ok().body(usersList);
    }

    // Indicates that there'll be an ID inside the URL:
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User obj = service.findUserById(id);
        return  ResponseEntity.ok().body(obj);
    }
}
