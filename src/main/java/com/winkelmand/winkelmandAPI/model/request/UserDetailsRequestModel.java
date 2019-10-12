package com.winkelmand.winkelmandAPI.model.request;

import java.util.List;

// Dit is een klasse waarmee inkomende JSon info 
// wordt omgezet naar een Java klasse
//UserRest en UserDetailsRequestModel bevatten verschillende
//informatie. UserDetailsRequestModel betrokken bij POST

public class UserDetailsRequestModel {

	//JSON zal de volgende onderdelen moeten bevatten
	//bijvoorbeeld bij het gebruiken van POST requests
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<BasketDetailsRequestModel> baskets;
	

	public List<BasketDetailsRequestModel> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<BasketDetailsRequestModel> baskets) {
		this.baskets = baskets;
	}

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
