package com.isaiasgabriel.spring_backend.services;

import com.isaiasgabriel.spring_backend.entities.Category;
import com.isaiasgabriel.spring_backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.get();
        // TODO: If there's no category inside the Optional object it'll throw an error
        // TODO: So we need to threat this error
    }
}
