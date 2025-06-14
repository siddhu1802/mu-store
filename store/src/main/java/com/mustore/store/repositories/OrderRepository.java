package com.mustore.store.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mustore.store.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByEmail(String email);
}