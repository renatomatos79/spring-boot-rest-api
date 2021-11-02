package com.inforplus.user.dto;

import java.math.BigDecimal;

public class AccountCreateRequest {
	private String name;
	private BigDecimal amount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
