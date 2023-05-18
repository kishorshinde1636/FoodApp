package com.ty.SpringBoot_FoodApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderIdNotFoundException extends RuntimeException {

	private String message="FoodOrder Id Not Found ";
}
