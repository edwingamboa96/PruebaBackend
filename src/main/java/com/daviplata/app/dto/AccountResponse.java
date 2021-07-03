package com.daviplata.app.dto;

import java.util.Date;

public class AccountResponse {
	
	private String message;
	
	private Date creationDate;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
	

}
