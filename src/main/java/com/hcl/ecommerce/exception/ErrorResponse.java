package com.hcl.ecommerce.exception;

public class ErrorResponse {
	
	private String message;
	
	private int Statuscode;

	public ErrorResponse() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatuscode() {
		return Statuscode;
	}

	public void setStatuscode(int statuscode) {
		Statuscode = statuscode;
	}
}
