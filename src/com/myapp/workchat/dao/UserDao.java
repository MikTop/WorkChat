package com.myapp.workchat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import com.myapp.workchat.entity.User;
import com.myapp.workchat.util.ConnectionManager;

import lombok.SneakyThrows;

public class UserDao implements Dao<Integer, User>{
	
	private static final String SQL_SAVE = """
			 INSERT INTO user (first_name, second_name, email, password, image, birthday)
			VALUES (?, ?, ?, ?, ?, ?)""";
			

	@Override
	public List<User> findAll() {
		
		return null;
	}

	@Override
	public Optional<User> findById(Integer id) {
		
		return null;
	}

	@Override
	public void update(Integer id) {
		
		
	}

	@Override
	public Boolean delete(Integer id) {
	
		return null;
	}

	@Override
	@SneakyThrows
	public User save(User entity) {
		try(Connection connection = ConnectionManager.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, Statement.RETURN_GENERATED_KEYS )){
			preparedStatement.setObject(1, entity.getFirstName());
			preparedStatement.setObject(2, entity.getSecondName());
			preparedStatement.setObject(3, entity.getEmail());
			preparedStatement.setObject(4, entity.getPassword());
			preparedStatement.setObject(5, entity.getImage());
			preparedStatement.setObject(6, entity.getBirthday());
			
			preparedStatement.execute();
			
			ResultSet genetatedKeys = preparedStatement.getGeneratedKeys();
			genetatedKeys.next();
			
			entity.setId(genetatedKeys.getObject("id", Integer.class));
			return entity;
		}
		
	}

	
}
