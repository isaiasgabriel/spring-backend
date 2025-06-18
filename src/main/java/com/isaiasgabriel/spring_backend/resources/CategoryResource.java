package com.isaiasgabriel.spring_backend.resources;

import com.isaiasgabriel.spring_backend.entities.Category;
import com.isaiasgabriel.spring_backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/categories") // request at localhost/users
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> usersList = service.findAll();
        return ResponseEntity.ok().body(usersList);
    }

    // Indicates that there'll be an ID inside the URL:
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findUserById(@PathVariable Long id){
        Category obj = service.findCategoryById(id);
        return  ResponseEntity.ok().body(obj);
    }
}
