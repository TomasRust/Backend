package com.winkelmand.winkelmandAPI.model.response;


// Klasse waarmee Java objecten worden omgezet naar JSON 
// UserRest en UserDetailsRequestModel bevatten verschillende
// informatie
// UserRest geeft een bevestiging terug om aan te geven 
// wat er in de database is toegevoegd


public class UserRest {

	// userId is anders dan de auto-increment key
	private String userId;
	private String firstName;
	private String lastName;
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

}
