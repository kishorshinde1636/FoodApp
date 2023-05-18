package com.ty.SpringBoot_FoodApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;
import com.ty.SpringBoot_FoodApp.dao.UserDao;
import com.ty.SpringBoot_FoodApp.dto.User;
import com.ty.SpringBoot_FoodApp.exception.UserIdNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("user save");
		responseStructure.setData(dao.saveUser(user));
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {
		User user2 = dao.updateUser(user, id);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();


		if (user2 != null) {
			
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("updated");
			responseStructure.setData(user);
			//return responseStructure;
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
		} else {
			throw new UserIdNotFoundException("user id not found");
		}
	}

	public ResponseEntity<ResponseStructure<User>>deleteUser(int id) {
		User user = dao.deleteUser(id);

		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (user != null) {

			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("deleted");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
			//return responseStructure;
		
		} else {
			throw new UserIdNotFoundException("user id not found");
		}

	}

	public ResponseEntity<ResponseStructure<User>> getUserById(int id) {
		User user = dao.getUserById(id);
		ResponseStructure<User> responseStructure=new ResponseStructure<>();
		if (user != null) {
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("found");
			responseStructure.setData(user);
			return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
			//return responseStructure;	
			} 
		else {
			throw new UserIdNotFoundException("user id not found");
		}

	}

}
