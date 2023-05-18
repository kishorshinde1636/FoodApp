package com.ty.SpringBoot_FoodApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.FoodOrderDao;
import com.ty.SpringBoot_FoodApp.dto.FoodOrder;
import com.ty.SpringBoot_FoodApp.dto.Items;
import com.ty.SpringBoot_FoodApp.exception.FoodOrderIdNotFoundException;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao foodOrderDao;

	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {

		List<Items> list = foodOrder.getItems();
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		double totalPrice = 0;
		for (Items items : list) {
			totalPrice += items.getCost() * items.getQuantity();
			foodOrder.setTotalPrice(totalPrice);
		}
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("FoodOrder save");
		responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
		// return responseStructure;
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(int id, FoodOrder foodOrder) {

		FoodOrder foodOrder2 = foodOrderDao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder2 != null) {
			List<Items> list = foodOrder2.getItems();
			double totalPrice = 0;
			for (Items items : list) {
				totalPrice += items.getCost() * items.getQuantity();

			}
			foodOrder.setTotalPrice(totalPrice);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("FoodOrder updated");
			responseStructure.setData(foodOrderDao.updateFoodOrder(id, foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
			// return responseStructure;
			// return foodOrderDao.updateFoodOrder(id, foodOrder);
		} else {
			throw new FoodOrderIdNotFoundException("foodorder id not found ");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(int id) {
		FoodOrder foodOrder = foodOrderDao.deleteFoodOrder(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();

		if (foodOrder != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("FoodOrder deleted");
			responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);
			// return responseStructure;
			// return foodOrder;

		} else {
			throw new FoodOrderIdNotFoundException("foodorder id not found ");
		}
	}

	public ResponseEntity<ResponseStructure<FoodOrder>> getById(int id) {

		FoodOrder foodOrder = foodOrderDao.getFoodOrderById(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (foodOrder != null) {

			List<Items> list = foodOrder.getItems();
			double price = 0;

			for (Items items : list) {
				price += items.getCost() * items.getQuantity();
			}
			foodOrder.setTotalPrice(price);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(foodOrderDao.saveFoodOrder(foodOrder));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.FOUND);
			// return responseStructure;
			// return foodOrder;
		} else {
			throw new FoodOrderIdNotFoundException("foodorder id not found ");
		}
	}
}
