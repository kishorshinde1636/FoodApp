package com.ty.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBoot_FoodApp.dto.Items;

public interface ItemRepo extends JpaRepository<Items, Integer> {

}
