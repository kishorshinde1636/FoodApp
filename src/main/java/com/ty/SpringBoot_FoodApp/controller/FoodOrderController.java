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
import com.ty.SpringBoot_FoodApp.dto.FoodOrder;
import com.ty.SpringBoot_FoodApp.service.FoodOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class FoodOrderController {

	
	@Autowired
	private FoodOrderService foodOrderService;
	
	
	@ApiOperation(value = "save FoodOrder",notes = "API is used to save FoodOrder for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully save"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PostMapping("/saveFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveFoodOrder(@RequestBody FoodOrder foodOrder)
	{
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	
	@ApiOperation(value = "update FoodOrder",notes = "API is used to update FoodOrder for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully update"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PutMapping("/updateFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(@RequestBody FoodOrder foodOrder,@RequestParam int id)
	{
		return foodOrderService.updateFoodOrder(id,foodOrder);
	}
	
	
	@ApiOperation(value = "delete FoodOrder",notes = "API is used to delete FoodOrder for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully delete"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@DeleteMapping("/deleteFoodOrder")
	public ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder(@RequestParam int id)
	{
		return foodOrderService.deleteFoodOrder(id);
	}
	
	
	@ApiOperation(value = "get FoodOrder By Id ",notes = "API is used to get FoodOrder By Id for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully get By Id"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@GetMapping("/getById")
	public ResponseEntity<ResponseStructure<FoodOrder>> getById(@RequestParam int id)
	{
		return foodOrderService.getById(id);
	}
	
	
}
