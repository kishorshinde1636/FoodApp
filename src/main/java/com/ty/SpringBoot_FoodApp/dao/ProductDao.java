package com.ty.SpringBoot_FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.SpringBoot_FoodApp.dto.Product;
import com.ty.SpringBoot_FoodApp.repo.ProductRepo;

import io.swagger.annotations.ApiOperation;

@Repository
public class ProductDao {

	@Autowired
     private ProductRepo productRepo;
	
	

//	@ApiOperation(value = "saveproduct", notes = "api is used to save product")
	
	
	public Product saveProduct(Product product)
	{
		return productRepo.save(product);
	}
	
	public Product updateProduct(int id,Product product)
	{
		Optional<Product> product2=productRepo.findById(id);
		
		if(product2.isPresent())
		{
			product.setPid(id);
			productRepo.save(product);
			return product2.get();
		}
		else {
			return null;
		}
	}

	public Product deleteProduct(int id) {
		Optional<Product> product= productRepo.findById(id);
		
		if(product.isPresent())
		{
			productRepo.deleteById(id);
			return product.get();
		}
		else {
			return null;

		}
 	}

	public Product getProductById(int id) {
	Optional<Product> product= productRepo.findById(id);
		
		if(product.isPresent())
		{
			productRepo.deleteById(id);
			return product.get();
		}
		else {
			return null;

		}
	}
}
