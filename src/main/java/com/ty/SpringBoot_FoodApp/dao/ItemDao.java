package com.ty.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.Items;
import com.ty.SpringBoot_FoodApp.repo.ItemRepo;

@Repository
public class ItemDao {

	@Autowired
	private ItemRepo repo;

	public Items saveItem(Items items) {

		return repo.save(items);
	}

	public Items updateItem(int id, Items items) {

		Optional<Items> items2 = repo.findById(id);

		if (items2.isPresent()) {
			items.setItem_id(id);
			repo.save(items);
			return items2.get();
		} else {
			return null;

		}
	}

	public Items deleteItem(int id) {
		Optional<Items> items = repo.findById(id);

		if (items.isEmpty()) {
			return null;
		} else {
			repo.deleteById(id);
			return items.get();
		}
	}

	public Items getItemById(int id) {
		
	Optional<Items> items=repo.findById(id);
	
	if(items.isEmpty())
	{
		return null;
	}
	else {
		return items.get();
	}
	}

}
