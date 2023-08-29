package com.cyr.restfulservice.exception;

public class StudentNotFoundException extends Exception {

	private String errorMsg;

	public StudentNotFoundException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}
	
	
}
