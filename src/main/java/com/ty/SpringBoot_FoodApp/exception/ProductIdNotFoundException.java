package com.ty.SpringBoot_FoodApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductIdNotFoundException extends RuntimeException {

	private String message="Product Not Found";
}
