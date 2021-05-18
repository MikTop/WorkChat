package com.myapp.workchat.validators;

public interface Validator<T>{
	
	public ValidationResult isValid(T object);

}
