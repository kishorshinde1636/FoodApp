package com.ty.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.ProductDao;
import com.ty.SpringBoot_FoodApp.dto.Product;
import com.ty.SpringBoot_FoodApp.dto.User;
import com.ty.SpringBoot_FoodApp.exception.ProductIdNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductDao dao;

	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("product save");
		responseStructure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		// return responseStructure;

	}

	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) {
		Product product2 = dao.updateProduct(id, product);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product2 != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("product updated");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
		//	return responseStructure;

		} else {
			throw new ProductIdNotFoundException("product not found");		}
	}

	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) {

		Product product = dao.deleteProduct(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();

		if (product != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.OK);
			//return responseStructure;
		} else {
			throw new ProductIdNotFoundException("product not found");		}
	}

	public ResponseEntity<ResponseStructure<Product>> getProductById(int id) {

		Product product = dao.getProductById(id);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		if (product != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.FOUND);
		//	return responseStructure;
		} else {
			throw new ProductIdNotFoundException("product not found");
		}
	}
}
