package com.mustore.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mustore.store.model.Order;
import com.mustore.store.repositories.OrderRepository;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/{email}")
    public List<Order> getOrderById(@PathVariable String email) {
        return orderRepository.findByEmail(email);

    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setName(order.getName());
        order.setPrice(order.getPrice());
        order.setQty(order.getQty());
        order.setEmail(order.getEmail());
        order.setOrderStatus("Pending");
        return orderRepository.save(order);
       
    }
}