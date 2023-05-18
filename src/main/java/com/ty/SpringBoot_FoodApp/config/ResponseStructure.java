package com.ty.SpringBoot_FoodApp.config;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private int status;
	private String message;
	private Object data;

}
