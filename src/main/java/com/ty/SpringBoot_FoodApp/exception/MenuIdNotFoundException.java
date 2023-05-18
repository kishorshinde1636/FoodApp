package com.ty.SpringBoot_FoodApp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MenuIdNotFoundException extends RuntimeException {

	private String message="Menu Id Not found";
}
