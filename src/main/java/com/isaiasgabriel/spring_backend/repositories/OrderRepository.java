package com.isaiasgabriel.spring_backend.repositories;

import com.isaiasgabriel.spring_backend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// By extending JpaRepository, Spring Data JPA automatically provides
// the implementation for standard CRUD operations.

public interface OrderRepository extends JpaRepository<Order, Long> {
}
