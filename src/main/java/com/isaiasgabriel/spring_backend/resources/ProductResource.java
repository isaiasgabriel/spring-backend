package com.isaiasgabriel.spring_backend.resources;

import com.isaiasgabriel.spring_backend.entities.Product;
import com.isaiasgabriel.spring_backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/products") // request at localhost/users
public class ProductResource {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> usersList = service.findAll();
        return ResponseEntity.ok().body(usersList);
    }

    // Indicates that there'll be an ID inside the URL:
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findUserById(@PathVariable Long id){
        Product obj = service.findProductById(id);
        return  ResponseEntity.ok().body(obj);
    }
}
