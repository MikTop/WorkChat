package com.myapp.workchat.service;

import java.util.List;
import java.util.Optional;import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.myapp.workchat.dao.UserDao;
import com.myapp.workchat.dto.UserCreate;
import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.dto.UserMinimal;
import com.myapp.workchat.entity.User;
import com.myapp.workchat.mappers.CreateUserMapper;
import com.myapp.workchat.mappers.UserDtoMapper;
import com.myapp.workchat.mappers.UserMinMapper;
import com.myapp.workchat.validators.CreateUserValidator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserService {
	
	private static final UserService INCTANCE = new UserService();
	
	
	
	private final UserDao userDao = UserDao.getInctance();
	private final CreateUserMapper createUserMapper = CreateUserMapper.getInctance();
	private final CreateUserValidator createUserValidator = CreateUserValidator.getInctance();
	private final UserDtoMapper userDtoMapper = UserDtoMapper.getInctance();
	private final ImageService imageService = ImageService.getInctance();
	private final UserMinMapper userMinMapper = UserMinMapper.getInctance();
	
	
	
	@SneakyThrows
	public  User createUser (UserCreate userCreate) {
		User user = createUserMapper.MapToUser(userCreate);
		if(userCreate.getImage().getSize() > 0) {
		imageService.saveImage(user.getImage(), userCreate.getImage().getInputStream());
		}else {
			user.setImage("users\\tiger.jpg");
		}
		// TODO Вынести в валидатор эту проверку
		return userDao.save(user);
		
		}
	
	
	
	public Optional<UserDto> getUserByEmailAndPassword (String email, String password) {
		
		return userDao.findByEmailAndPassword(email, password)
				.map(user -> userDtoMapper.mapTo(user));
		
		}
	
public List<UserMinimal> findAll () {
		
		return userDao.findAll().stream()
				.map(user -> userMinMapper.mapTo(user))
				.collect(Collectors.toList());
		
		}
	
	
	
	
	public static UserService getInctance() {
		return INCTANCE;
	}

}
