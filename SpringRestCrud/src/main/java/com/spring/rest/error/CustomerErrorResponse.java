package com.spring.rest.error;

import java.util.Date;

public class CustomerErrorResponse {
	
	private int status;
	private String message;
	private Date timeStamp;
	
	public CustomerErrorResponse()
	{
		
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	

}
