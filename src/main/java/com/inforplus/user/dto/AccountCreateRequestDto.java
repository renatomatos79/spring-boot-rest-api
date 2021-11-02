package com.inforplus.user.dto;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AccountCreateRequestDto {
	@NotBlank(message = "The name is required.")
	@Size(min = 3, max = 60, message = "The length of full name must be between 3 and 100 characters.")
	private String name;
	
	@Min(value = (long)0, message = "The amount must be higher or equal to zero.")
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
