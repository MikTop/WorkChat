package com.myapp.workchat.validators;

import java.util.ArrayList;
import java.util.List;

public class ValidationResult {

	private List<Error> errors = new ArrayList<>();
	
	public void add (Error error) {
		errors.add(error);
	}
	
	public List<Error> getErrors (){
		return errors;
	}
	
	public boolean isValid() {
		return errors.isEmpty();
	}
}
