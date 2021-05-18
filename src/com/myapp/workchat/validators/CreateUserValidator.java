package com.myapp.workchat.validators;

import com.myapp.workchat.dto.UserCreate;
import com.myapp.workchat.entity.Role;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserValidator implements Validator <UserCreate>{
	
	
	private static final CreateUserValidator INCTANCE = new CreateUserValidator();
	

	@Override
	public ValidationResult isValid(UserCreate object) {
		ValidationResult validationResult = new ValidationResult();
		if(Role.find(object.getRole()) == null) {
			validationResult.add(Error.of("01", "role not valid"));
		}
			
			
			
			
		return validationResult;
	}

	
	public static CreateUserValidator getInctance() {
		return INCTANCE;
	}
	
	
	
}



