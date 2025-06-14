package com.mustore.store.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustore.store.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByNameContainingIgnoreCase(String keyword);

}