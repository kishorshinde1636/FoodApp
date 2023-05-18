package com.ty.SpringBoot_FoodApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.SpringBoot_FoodApp.dto.User;

public interface UserRepo extends JpaRepository<User, Integer> 
{
  
}
