package com.ty.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.FoodOrder;
import com.ty.SpringBoot_FoodApp.repo.FoodOrderRepo;

@Repository
public class FoodOrderDao {

	@Autowired
	private FoodOrderRepo foodOrderRepo;

	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}

	public FoodOrder getFoodOrderById(int id) {
		Optional<FoodOrder> foodOrder = foodOrderRepo.findById(id);

		if (foodOrder.isPresent()) {
			return foodOrder.get();
		} else {
			return null;
		}
	}

	public FoodOrder updateFoodOrder(int id, FoodOrder foodOrder) {
		Optional<FoodOrder> foodOrder2 = foodOrderRepo.findById(id);

		if (foodOrder2.isPresent()) {
			foodOrder.setFid(id);
			foodOrder.setItems(foodOrder.getItems());
			foodOrderRepo.save(foodOrder);
			return foodOrder2.get();
		} else {
			return null;
		}
	}

	
	public FoodOrder deleteFoodOrder(int id)
	{
	Optional<FoodOrder> foodOrder=foodOrderRepo.findById(id);
	
	if(foodOrder.isPresent())
	{
		foodOrderRepo.deleteById(id);
		return foodOrder.get();
	}
	else {
		return null;
	}
	
	}
}
