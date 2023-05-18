package com.ty.SpringBoot_FoodApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dto.User;
import com.ty.SpringBoot_FoodApp.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@ApiOperation(value = "save user",notes = "API is used to save user for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "sucessfully save"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(@Valid@RequestBody User user) {
		return service.saveUser(user);
	}

	@ApiOperation(value = "update user",notes = "API is used to update user for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "sucessfully update"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@PutMapping
	public ResponseEntity<ResponseStructure<User>>  updateUser(@Valid@RequestParam int id, @RequestBody User user) {
		return service.updateUser(id, user);

	}

	@ApiOperation(value = "delete user",notes = "API is used to delete user for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 200,message = "sucessfully delete"),
			               @ApiResponse(code = 404,message = "Id not found for the given Id")
	                       }
	               )
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@Valid@PathVariable int id) {
		return service.deleteUser(id);
	}

	@ApiOperation(value = "Get user By Id",notes = "API is used to get the user for given user Id")
	@ApiResponses(value = {@ApiResponse(code = 302,message = " user Id is found"),
			               @ApiResponse(code = 400,message = "Id not found for the given Id")
	                       }
	               )
	@GetMapping("/getuser")
	public ResponseEntity<ResponseStructure<User>> getUserById(@Valid@RequestParam int id) {
		return service.getUserById(id);
	}

}
