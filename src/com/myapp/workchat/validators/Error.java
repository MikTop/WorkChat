package com.myapp.workchat.validators;

import lombok.Value;

@Value(staticConstructor = "of")
public class Error {

	private String code;
	private String message;
	
}
