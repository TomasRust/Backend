package com.winkelmand.winkelmandAPI.dto;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.winkelmand.winkelmandAPI.entity.BasketEntity;

public class BasketDto implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long basketId;
//	private String basketId;
	private String productName;
	private int amount;
	private int price;
	private UserDto userDetails;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public UserDto getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDto userDetails) {
		this.userDetails = userDetails;
	}
	public long getBasketId() {
		return basketId;
	}
	public void setBasketId(long basketId) {
		this.basketId = basketId;
	}
	
	public Long save(BasketEntity basketEntity) {
		return (Long) sessionFactory.getCurrentSession().save(basketEntity);
	}
	
	

}
