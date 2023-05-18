package com.ty.SpringBoot_FoodApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@NotNull(message = "pName should not be null")
	@NotBlank(message = "pName should not blank")
	private String pname;
	@NotNull(message = "Description should not be null")
	@NotBlank(message = "Description should not blank")
	private String description;
	@NotNull(message = "price should not be null")
	@NotBlank(message = "price should not blank")
	private String price;
	@NotNull(message = "category should not be null")
	@NotBlank(message = "category should not blank")
	private String category;
	

}
