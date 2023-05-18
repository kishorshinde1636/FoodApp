package com.ty.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBoot_FoodApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {

}
