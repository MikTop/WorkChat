package com.myapp.workchat.service;

import java.util.Optional;

import com.myapp.workchat.dao.UserDao;
import com.myapp.workchat.dto.UserCreate;
import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.entity.User;
import com.myapp.workchat.mappers.CreateUserMapper;
import com.myapp.workchat.mappers.UserDtoMapper;
import com.myapp.workchat.validators.CreateUserValidator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
	
	private static final UserService INCTANCE = new UserService();
	
	
	
	private final UserDao userDao = UserDao.getInctance();
	private final CreateUserMapper createUserMapper = CreateUserMapper.getInctance();
	private final CreateUserValidator createUserValidator = CreateUserValidator.getInctance();
	private final UserDtoMapper userDtoMapper = UserDtoMapper.getInctance();
	
	
	
	
	public  User createUser (UserCreate userCreate) {
		
		return userDao.save(createUserMapper.MapToUser(userCreate));
		
		}
	
	
	
	public Optional<UserDto> getUserByEmailAndPassword (String email, String password) {
		
		return userDao.findByEmailAndPassword(email, password)
				.map(user -> userDtoMapper.mapTo(user));
		
		}
	
	
	
	
	
	
	public static UserService getInctance() {
		return INCTANCE;
	}

}
