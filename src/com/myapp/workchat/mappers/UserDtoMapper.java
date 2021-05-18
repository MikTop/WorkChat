package com.myapp.workchat.mappers;

import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.entity.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDtoMapper {
	
	private static final UserDtoMapper INCTANCE = new UserDtoMapper();
	
	
	public UserDto mapTo (User user) {
		return UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.secondName(user.getSecondName())
				.email(user.getEmail())
				.role(user.getRole())
				.birthday(user.getBirthday())
				.build();
				
	}
	
	
	
	
	
	
	
	public static UserDtoMapper getInctance (){
		return INCTANCE;
	}
}







