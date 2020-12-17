package com.hcl.ecommerce.dto;

import javax.validation.constraints.NotNull;

public class ProductDto {
	
	@NotNull(message = "userType should be mandatory")
	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
