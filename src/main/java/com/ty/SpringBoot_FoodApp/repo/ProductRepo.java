package com.ty.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBoot_FoodApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
