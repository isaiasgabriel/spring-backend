package com.isaiasgabriel.spring_backend.config;

import com.isaiasgabriel.spring_backend.entities.Order;
import com.isaiasgabriel.spring_backend.entities.User;
import com.isaiasgabriel.spring_backend.entities.enums.OrderStatus;
import com.isaiasgabriel.spring_backend.repositories.OrderRepository;
import com.isaiasgabriel.spring_backend.repositories.UserRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestProfileConfig implements CommandLineRunner {
    // This class will basically seed (populate) our database with data we can test.
    // In order to do this we need to connect with the database,
    // We'll do this using dependency injection.
    // @Autowired is basically saying: "Hey Spring, inject me an instance of this class here so I can use it."
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID ,u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
