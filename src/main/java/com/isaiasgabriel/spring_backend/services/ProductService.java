package com.isaiasgabriel.spring_backend.services;

import com.isaiasgabriel.spring_backend.entities.Product;
import com.isaiasgabriel.spring_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Component is how you register a component
// But since it's a Service we are more specific
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findProductById(Long id) {
        Optional<Product> product= repository.findById(id);
        return product.get();
        // TODO: If there's no user inside the Optional object it'll throw an error
        // TODO: So we need to threat this error
    }
}
