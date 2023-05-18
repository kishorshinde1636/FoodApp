package com.ty.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBoot_FoodApp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer> {

}
