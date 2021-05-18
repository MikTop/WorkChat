package com.myapp.workchat.exception;

import java.util.List;

import com.myapp.workchat.validators.Error;

import lombok.AllArgsConstructor;


public class MyAppException extends RuntimeException {
	
	private List<Error> errors;
	
	public MyAppException(List<Error> errors) {
		this.errors = errors;
	}
	
}
