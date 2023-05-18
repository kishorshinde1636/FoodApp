package com.ty.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.MenuDao;
import com.ty.SpringBoot_FoodApp.dto.Menu;
import com.ty.SpringBoot_FoodApp.exception.MenuIdNotFoundException;

@Service
public class MenuService {

	@Autowired
	private MenuDao dao;

	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu) {

		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("saved");
		responseStructure.setData(dao.saveMenu(menu));

		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);
		// return responseStructure;

	}

	public ResponseEntity<ResponseStructure<Menu>> updateMenu(int id, Menu menu) {
		Menu menu2 = dao.updateMenu(id, menu);
		if (menu2 != null) {
			ResponseStructure<Menu> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
			// return responseStructure;
		} else {
			throw new MenuIdNotFoundException("menu id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(int mid) {

		Menu menu = dao.deleteMenu(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();

		if (menu != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);
			// return responseStructure;
		}

		else {
			throw new MenuIdNotFoundException("menu id not found");
		}
	}

	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int mid) {
		Menu menu = dao.getMenuById(mid);
		ResponseStructure<Menu> responseStructure = new ResponseStructure<>();

		if (menu != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(menu);
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.FOUND);
			// return responseStructure;
		} else {
			throw new MenuIdNotFoundException("menu id not found");
		}

	}
}
