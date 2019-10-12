package com.winkelmand.winkelmandAPI.model.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.winkelmand.winkelmandAPI.entity.ItemEntity;
import com.winkelmand.winkelmandAPI.entity.UserEntity;

public class BasketDetailsRequestModel {
	
	private Long basketId;
	private UserEntity userEntity;
	private BigDecimal totalPrice;
	private List<ItemEntity> items = new ArrayList<ItemEntity>();
	
	
	public Long getBasketId() {
		return basketId;
	}
	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<ItemEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}

}
