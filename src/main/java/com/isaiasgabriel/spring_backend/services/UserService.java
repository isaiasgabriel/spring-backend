package com.isaiasgabriel.spring_backend.services;

import com.isaiasgabriel.spring_backend.entities.User;
import com.isaiasgabriel.spring_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @Component is how you register a component
// But since it's a Service we are more specific
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findUserById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
        // TODO: If there's no user inside the Optional object it'll throw an error
        // TODO: So we need to threat this error
    }

    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User obj) {
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPhone());
    }
}
