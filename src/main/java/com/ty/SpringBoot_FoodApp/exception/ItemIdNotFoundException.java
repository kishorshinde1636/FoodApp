package com.ty.SpringBoot_FoodApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemIdNotFoundException extends RuntimeException {

	private String message="Item Id Not Found ";
}
