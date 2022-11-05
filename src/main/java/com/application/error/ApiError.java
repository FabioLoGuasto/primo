package com.application.error;

public class ApiError {
	int status;
	String message;
	long timestamp;
	String path;
	
	public ApiError(int status, String message, String path) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
	}
}
