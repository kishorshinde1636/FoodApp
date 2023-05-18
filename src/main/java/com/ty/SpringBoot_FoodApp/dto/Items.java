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
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	@NotNull(message = "item_name should not be null")
	@NotBlank(message = "item_name should not blank")
	private String item_name;
	@NotNull(message = "cost should not be null")
	@NotBlank(message = "cost should not blank")
	private double cost;
	@NotNull(message = "quantity should not be null")
	@NotBlank(message = "quantity should not blank")
	private int quantity;

}
