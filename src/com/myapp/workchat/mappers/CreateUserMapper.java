package com.myapp.workchat.mappers;



import com.myapp.workchat.dto.UserCreate;
import com.myapp.workchat.entity.Role;
import com.myapp.workchat.entity.User;
import com.myapp.workchat.util.LocalDateFormatter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateUserMapper {
	
	private final static CreateUserMapper INCTANCE = new CreateUserMapper();
	
	public static CreateUserMapper getInctance () {
		return INCTANCE;
	}
	
	public User MapToUser (UserCreate userCreate) {
		User user = User.builder()
				.firstName(userCreate.getFirstName())
				.secondName(userCreate.getSecondName())
				.email(userCreate.getEmail())
				.password(userCreate.getPassword())
				.image(userCreate.getImage())
				.role(Role.find(userCreate.getRole()).orElse(null))
				.birthday(LocalDateFormatter.format(userCreate.getBirthday()))
				.id(0)
				.build();
				
		return user;
		
	}
	
}
