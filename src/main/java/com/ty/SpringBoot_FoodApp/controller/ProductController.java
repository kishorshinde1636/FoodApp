package com.ty.SpringBoot_FoodApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dto.Product;
import com.ty.SpringBoot_FoodApp.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	
	@ApiOperation(value = "save product",notes = "API is used to save product for given product Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully save"),
			               @ApiResponse(code = 400,message = "Id not found for the given Id")
	                       }
	               )
	@PostMapping("/saveproduct")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	
	@ApiOperation(value = "update product",notes = "API is used to update product for given product Id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "sucessfully update"),
			               @ApiResponse(code = 400,message = "Id not found for the given Id")
	                       }
	               )
	@PutMapping("/updateProduct")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestParam int id,@RequestBody Product product)
	{
		return service.updateProduct(id, product);
	}
	
	
	@ApiOperation(value = "delete product",notes = "API is used to  delete for given product Id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "sucessfully delete"),
			               @ApiResponse(code = 400,message = "Id not found for the given Id")
	                       }
	               )
	@DeleteMapping("/deleteproduct")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@RequestParam int id)
	{
		return service.deleteProduct(id);
		
		
	}
	
	@ApiOperation(value = "get product By Id",notes = "API is used to  get product for given product Id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "sucessfully get product By Id"),
			               @ApiResponse(code = 400,message = "Id not found for the given Id")
	                       }
	               )
	@GetMapping("/getproduct")
	public ResponseEntity<ResponseStructure<Product>> getProductById(@RequestParam int id)
	{
		return service.getProductById(id);
	}
}


//http://localhost:8080/swagger-ui.html#/