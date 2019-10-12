package com.winkelmand.winkelmandAPI.model.response;

import java.math.BigDecimal;

import com.winkelmand.winkelmandAPI.entity.BasketEntity;

public class ItemRest {
	
	private Long itemId;
	private String itemName;
	private BasketEntity basketEntity;
	//private ProductEntity productEntity;
	private Integer quantity;
	private BigDecimal price;
	
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BasketEntity getBasketEntity() {
		return basketEntity;
	}
	public void setBasketEntity(BasketEntity basketEntity) {
		this.basketEntity = basketEntity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
