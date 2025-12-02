package com.learn.burgerapp.dto;

import jakarta.validation.constraints.Max; 
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

	private String id;
	
	@NotNull(message = "Name cannot be null")
	@NotBlank(message = "Name cannot be blank")
	@Size(min = 2,max = 40)
	private String name;
	
	@NotNull(message = "Password cannot be null")
	@NotBlank(message = "Password cannot be blank")
	@Pattern(regexp = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{6,})\\S$")
	private String password;
	
	private String confirmPassowrd;
	
	private String email;
	 @Min(10)
	 @Max(100)
	 private int age;
}
