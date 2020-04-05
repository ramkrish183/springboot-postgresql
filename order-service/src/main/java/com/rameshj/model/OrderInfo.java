package com.rameshj.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_history")
public class OrderInfo {
	
	@Id
	@GeneratedValue
	private Integer orderId;
	private String productName;
	private Integer quantity;
	private Integer price;
	private UserInformation userinfo;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public UserInformation getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInformation userinfo) {
		this.userinfo = userinfo;
	}

}
