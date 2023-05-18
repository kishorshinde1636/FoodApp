package com.ty.SpringBoot_FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class FoodOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fid;
	@NotNull(message = "fname should not be null")
	@NotBlank(message = "fname should not blank")
	private String fname;
	@NotNull(message = "address should not be null")
	@NotBlank(message = "address should not blank")
	private String address;
	@Min(6000000000l)
	@Max(9999999999l)
	private long phone;
	@NotNull(message = "totalPrice should not be null")
	@NotBlank(message = "totalPrice should not blank")
	private double totalPrice;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Items> items;

}
