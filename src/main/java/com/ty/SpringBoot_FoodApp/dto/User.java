package com.ty.SpringBoot_FoodApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name should not be null")
	@NotBlank(message = "name should not blank")
	private String name;
	@NotNull(message = "address should not be null")
	@NotBlank(message = "address should not blank")
	private String address;
	@NotNull(message = "email should not be null")
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", message = "invalid email")
	private String email;
	@NotNull(message = "role should not be null")
	@NotBlank(message = "role should not blank")
	private String role;
	@Min(6000000000l)
	@Max(9999999999l)
	private long phone;
	@Pattern(regexp = "^(?=.*[0-9])+(?=.*[a-z])+(?=.*[A-Z])+(?=.*[@#$%^&+=])+(?=\\S+$).{6,}$", message = "min 6 characters mandatory(1 upperCase,1 lowerCase,1 special Character,1 number)")
	private String password;
}
