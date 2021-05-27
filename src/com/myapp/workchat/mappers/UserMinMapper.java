package com.myapp.workchat.mappers;

import static lombok.AccessLevel.PRIVATE;

import com.myapp.workchat.dto.UserMinimal;
import com.myapp.workchat.entity.User;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class UserMinMapper {

	private static final UserMinMapper INCTANCE = new UserMinMapper();
	
	public UserMinimal mapTo (User user) {
		return UserMinimal.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.secondName(user.getSecondName())
				.build();
	}
	
	
	
	
	
	
	
	
	public static UserMinMapper getInctance() {
		return INCTANCE;
	}
}
