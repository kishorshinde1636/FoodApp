package com.ty.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.ItemDao;
import com.ty.SpringBoot_FoodApp.dto.Items;
import com.ty.SpringBoot_FoodApp.exception.ItemIdNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemDao dao;

	public ResponseEntity<ResponseStructure<Items>> saveItem(Items items) {

		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("user save");
		responseStructure.setData(dao.saveItem(items));
		return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
		// return responseStructure;
	}

	public ResponseEntity<ResponseStructure<Items>> updateItem(int id, Items items) {

		Items items2 = dao.updateItem(id, items);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items2 != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
			// return responseStructure;
		} else {
			throw new ItemIdNotFoundException("item not fopund");
		}
	}

	public ResponseEntity<ResponseStructure<Items>> deleteItem(int id) {
		Items items = dao.deleteItem(id);
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		if (items != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.OK);
			// return responseStructure;
		} else {
			throw new ItemIdNotFoundException("item not fopund");
		}
	}

	public ResponseEntity<ResponseStructure<Items>> getItemById(int id) {
		ResponseStructure<Items> responseStructure = new ResponseStructure<>();
		Items items = dao.getItemById(id);

		if (items != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(items);
			return new ResponseEntity<ResponseStructure<Items>>(responseStructure, HttpStatus.FOUND);
			// return responseStructure;
		} else {
			throw new ItemIdNotFoundException("item not fopund");
		}
	}

}
