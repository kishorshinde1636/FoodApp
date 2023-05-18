package com.ty.SpringBoot_FoodApp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mid;
	@NotNull(message = "mname should not be null")
	@NotBlank(message = "mname should not blank")
	private String mname;
	@NotNull(message = "venue should not be null")
	@NotBlank(message = "venue should not blank")
	private String venue;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> products;

}
