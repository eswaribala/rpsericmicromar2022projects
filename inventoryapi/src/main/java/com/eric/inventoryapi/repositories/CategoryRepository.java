package com.eric.inventoryapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eric.inventoryapi.models.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
