package com.winkelmand.winkelmandAPI.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "basket", catalog = "winkelmand")
public class BasketEntity implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long basketId;
	private UserEntity userEntity;
	private BigDecimal totalPrice;
	private List<ItemEntity> items = new ArrayList<ItemEntity>();
	
	public BasketEntity() {
	}
	
	public BasketEntity(Long basketId, UserEntity userEntity, BigDecimal totalPrice) {
		this.basketId = basketId;
		this.userEntity = userEntity;
		this.totalPrice = totalPrice;
	}
	
//	public Cart(Long idCart, Customer customer, BigDecimal subtotal, List<LineItem> linesItems) {
//			this.idCart = idCart;
//			this.customer = customer;
//			this.subtotal = subtotal;
//			this.linesItems = linesItems;
//		}

		@Id
		@Column(name = "basketId", unique = true, nullable = false)
		public Long getbasketId() {
			return this.basketId;
		}

		public void setbasketId(Long basketId) {
			this.basketId = basketId;
		}

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "userId", nullable = false)
		public UserEntity getUserEntity() {
			return this.userEntity;
		}

		public void setUserEntity(UserEntity userEntity) {
			this.userEntity = userEntity;
		}

		@Column(name = "totalPrice", nullable = false, precision = 10)
		public BigDecimal getTotalPrice() {
			return this.totalPrice;
		}

		public void setTotalPrice(BigDecimal totalPrice) {
			this.totalPrice = totalPrice;
		}

		@OneToMany(fetch = FetchType.LAZY) //mappedBy = "basket"
		@Cascade(CascadeType.SAVE_UPDATE)
		public List<ItemEntity> getbasketItems() {
			return this.items;
		}

		public void setbasketItems(List<ItemEntity> items) {
			this.items = items;
		}
		
		public BigDecimal calculateTotal(){
			BigDecimal total = BigDecimal.ZERO;
			for (ItemEntity itemEntity : this.getbasketItems()) {
				total.add(itemEntity.getPrice().multiply(new BigDecimal(itemEntity.getQuantity())));		
			}
			return total;
		}
	}
