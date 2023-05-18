package com.ty.SpringBoot_FoodApp.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.SpringBoot_FoodApp.config.ResponseStructure;

@ControllerAdvice
public class ApplicationHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userIdNotFound(UserIdNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("User Id Not Found");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ProductIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> productIdNotFound(ProductIdNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("Product Id Not Found");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ItemIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> itemIdNotFound(ItemIdNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("Item Id Not Found");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(MenuIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> menuIdNotFound(MenuIdNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("Menu Id Not Found");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FoodOrderIdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> foodOrderIdNotFound(FoodOrderIdNotFoundException ex) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(ex.getMessage());
		responseStructure.setData("FoodOrder Id Not Found");

		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ObjectError> list = ex.getAllErrors();

		HashMap<String, String> hashMap = new HashMap<>();

		for (ObjectError error : list) {
			String message = error.getDefaultMessage();
			String fieldname = ((FieldError) error).getField();
			hashMap.put(fieldname, message);
		}

		return new ResponseEntity<Object>(hashMap, HttpStatus.BAD_REQUEST);
	}

}
