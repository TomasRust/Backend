package com.winkelmand.winkelmandAPI.dto;

import java.io.Serializable;
import java.util.List;

// Dto staat voor Data transfer object
// Dit is een Transfer Object design pattern

// Serializable is onderdeel van deze design pattern
// "serializable so that it can be transferred over the network"

public class UserDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String userId; // Database Id (Autoincremented)
//	private String userId; // Public Id --> Avoid people know all users id in DB
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<BasketDto> baskets;
	
	public List<BasketDto> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<BasketDto> baskets) {
		this.baskets = baskets;
	}

	public String getId() {
		return userId;
	}

	public void setId(String userId) {
		this.userId = userId;
	}

//	public String getUserById() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
