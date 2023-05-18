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
import com.ty.SpringBoot_FoodApp.dto.Items;
import com.ty.SpringBoot_FoodApp.service.ItemService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ItemController {

	@Autowired
	private ItemService service;

	@ApiOperation(value = "save Item",notes = "API is used to save item for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully save"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PostMapping("/saveiteam")
	public ResponseEntity<ResponseStructure<Items>> saveItem(@RequestBody Items items) {
		return service.saveItem(items);
	}

	@ApiOperation(value = "update menu",notes = "API is used to update menu for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully update"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PutMapping("/updateitem")
	public ResponseEntity<ResponseStructure<Items>> updateItem(@RequestParam int id, @RequestBody Items items) {
		return service.updateItem(id, items);

	}

	@ApiOperation(value = "delete menu",notes = "API is used to delete menu for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully delete"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@DeleteMapping("/deleteitem")
	public ResponseEntity<ResponseStructure<Items>> deleteItem(@RequestParam int id) {
		return service.deleteItem(id);
	}

	@ApiOperation(value = "get menu By ID",notes = "API is used to get menu By Id for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully get menu by Id"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@GetMapping("/getitembyid")
	public ResponseEntity<ResponseStructure<Items>> getItemById(@RequestParam int id) {
		return service.getItemById(id);
	}
}
