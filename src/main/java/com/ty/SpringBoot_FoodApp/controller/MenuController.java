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
import com.ty.SpringBoot_FoodApp.dto.Menu;
import com.ty.SpringBoot_FoodApp.service.MenuService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class MenuController {
	
	@Autowired 
	private MenuService service;
	
	@ApiOperation(value = "save menu",notes = "API is used to save menu for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully save"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu( @RequestBody Menu menu)
	{
		return service.saveMenu(menu);
	}
	

	@ApiOperation(value = "update menu",notes = "API is used to update menu for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully update"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PutMapping("/updatemenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestParam int id,@RequestBody Menu menu)
	{
	  return service.updateMenu(id, menu);
	}
	
	
	@ApiOperation(value = "delete menu",notes = "API is used to delete menu for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully delete"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@DeleteMapping("/deletemenu")
	public ResponseEntity<ResponseStructure<Menu>> deleteMenu(@RequestParam int mid)
	{
		return service.deleteMenu(mid);
	}
	
	
	@ApiOperation(value = "gte menu By Id",notes = "API is used to get menu By Id for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully get menu by Id"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	
	@GetMapping("/getbyid")
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(@RequestParam int mid)
	{
		return service.getMenuById(mid);
	}
}
