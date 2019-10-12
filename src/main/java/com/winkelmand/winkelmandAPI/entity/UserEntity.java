package com.winkelmand.winkelmandAPI.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;


// Klasse waarmee data in de database wordt toegevoegd

@Entity(name = "user")
public class UserEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

//	@Id //Primary key; auto-increment
//	@GeneratedValue
//	@Column(nullable = false, unique = true)
//	private String userId;
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(nullable = false, unique = true)
	private String userId;
	
	//Door het toevoegen van unique zullen er geen
	//users bestaan met dezelfde userId
//	@Column(nullable = false, unique = true)
//	@Column(nullable = false, unique = true)
//	private String userId;
	
//	@Column(nullable = false, length = 50)
	@Column(nullable = false, length = 50)
	private String firstName;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	//Door het toevoegen van unique zullen er geen
	//users bestaan met dezelfde email
	@Column(nullable = false, length = 120, unique = true)
	private String email;
	
	@Column(nullable = false, length = 120)
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL) //mappedBy="userDetails"
	private List<BasketEntity> baskets;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return userId;
	}

	public void setId(String userId) {
		this.userId = userId;
	}

//	public String getUserId() {
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

	public List<BasketEntity> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<BasketEntity> baskets) {
		this.baskets = baskets;
	}

}
