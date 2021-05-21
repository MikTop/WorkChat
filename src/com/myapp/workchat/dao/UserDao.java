package com.myapp.workchat.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myapp.workchat.entity.Role;
import com.myapp.workchat.entity.User;
import com.myapp.workchat.util.ConnectionManager;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao implements Dao<Integer, User>{
	
	private static final UserDao INCTANCE = new UserDao();
	
	private static final String SQL_FIND_ALL = """
			SELECT
			id, first_name, second_name, email, password, image, birthday, role 
			FROM user
			""";
	
	private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = """
			SELECT
			id, first_name, second_name, email, password, image, birthday, role 
			FROM user
			WHERE email = ? AND password = ?
			""";
	
	private static final String SQL_SAVE = """
			 INSERT INTO user (first_name, second_name, email, password, image, birthday, role)
			VALUES (?, ?, ?, ?, ?, ?, ?)""";
			

	@Override
	@SneakyThrows
	public List<User> findAll() {
		try(Connection connection = ConnectionManager.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)){
			
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			List<User> users = new ArrayList<>();
			while(resultSet.next()) {
				users.add(build(resultSet));
			}
			
			return users;
			 
		}
		
		
	}
	
	@SneakyThrows
	public Optional<User> findByEmailAndPassword(String email, String password) {
		
		try(Connection connection = ConnectionManager.openConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_BY_EMAIL_AND_PASSWORD)){
			
			preparedStatement.setObject(1, email);
			preparedStatement.setObject(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			User user = null;
			if(resultSet.next()) {
				user = build(resultSet);
						
			}
			return Optional.ofNullable(user);
		}
		
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
			preparedStatement.setObject(7, entity.getRole().name());
			
			
			preparedStatement.executeUpdate();
			
			ResultSet genetatedKeys = preparedStatement.getGeneratedKeys();
			genetatedKeys.next();
			
			entity.setId(genetatedKeys.getObject(1, Integer.class));
			return entity;
		}
		
	}
	@SneakyThrows
	private User build(ResultSet resultSet)  {

		
		return User.builder()
				.id(resultSet.getObject("id", Integer.class))
				.firstName(resultSet.getObject("first_name", String.class))
				.secondName(resultSet.getObject("second_name", String.class))
				.email(resultSet.getObject("email", String.class))
				.password(resultSet.getObject("password", String.class))
				.image(resultSet.getObject("image", String.class))
				.birthday(resultSet.getObject("birthday", Date.class).toLocalDate())
				.role(Role.find( resultSet.getObject("role", String.class)).orElse(null))
				.build();
				
	}
	
	public static UserDao getInctance () {
		return INCTANCE;
	}
	

	
}
