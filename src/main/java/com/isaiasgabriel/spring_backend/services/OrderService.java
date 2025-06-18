package com.isaiasgabriel.spring_backend.services;

import com.isaiasgabriel.spring_backend.entities.Order;
import com.isaiasgabriel.spring_backend.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

   @Autowired
   private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        return orderRepository.findById(id).get();
        // TODO: If there's no user inside the Optional object it'll throw an error
        // TODO: So we need to threat this error

    }
}
