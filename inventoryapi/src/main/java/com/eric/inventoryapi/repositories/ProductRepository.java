package com.eric.inventoryapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.inventoryapi.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
