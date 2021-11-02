package com.inforplus.user.models;

import java.math.BigDecimal;

public class Purchase {
	private int id;
	private String product;
	private BigDecimal price;
	
	public Purchase(int id, String product, BigDecimal price) {
		super();
		this.id = id;
		this.product = product;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}	
}
