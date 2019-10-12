package com.winkelmand.winkelmandAPI.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item", catalog = "winkelmand")
public class ItemEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long itemId;
	private String itemName;
	private BasketEntity basketEntity;
	//private ProductEntity productEntity;
	private Integer quantity;
	private BigDecimal price;
	
	public ItemEntity() {
		
	}
	public ItemEntity(String itemName, BasketEntity basketEntity, Integer quantity, BigDecimal price) {
		this.itemName = itemName;
		this.basketEntity = basketEntity;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Id
	@GeneratedValue  //(strategy = IDENTITY)
	@Column(name = "itemId", unique = true, nullable = false)
	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	
	@Column(name = "itemName", nullable = false)
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "basketId", nullable = false)
	public BasketEntity getBasketEntity() {
		return basketEntity;
	}

	public void setBasketEntity(BasketEntity basketEntity) {
		this.basketEntity = basketEntity;
	}

	@Column(name = "quantity", nullable = false)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Column(name = "price", nullable = false, precision = 10)
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


}
