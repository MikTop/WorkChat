package com.myapp.workchat.dao;

import static lombok.AccessLevel.PRIVATE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import com.myapp.workchat.entity.Chat;
import com.myapp.workchat.entity.User;
import com.myapp.workchat.util.ConnectionManager;
import com.myapp.workchat.util.RandomGenerator;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = PRIVATE)
public class ChatDao implements Dao<Integer, Chat>{
	
	private static final ChatDao INCTANCE = new ChatDao();
	
	private static final String SQL_CREATE_CHAT = """
			CREATE TABLE ? (
			id BIGINT PRIMARY KEY,
			message VARCHAR (400),
			sender_id INT NOT NULL 
			FOREIGN KEY (sender_id) REFERENCES user (id)
			)
			""";
	private static final String SQL_CREATE_CHAT_MEMBERS = """
			CREATE TABLE ? (
			user_id INT NOT NULL,
			FOREIGN KEY (user_id) REFERENCES user (id)
			)
			""";
	
	private static final String SQL_ADD_NEW_CHAT = """
			INSERT INTO all_chats (chat_id, chat_members_id) 
			VALUES (?, ?)
			""";
	
	private static final String SQL_FIND_CHAT_BY_ID = """
			SELECT name FROM all_chat
			WHERE name = ?
			""";
	
	
	@SneakyThrows
	public Chat createChat(List<User> chatMembers) {
		
		try(Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatementChat = connection.prepareStatement(SQL_CREATE_CHAT);
			PreparedStatement preparedStatementMembers = connection.prepareStatement(SQL_CREATE_CHAT_MEMBERS)){
			
			String chatId = RandomGenerator.getRandomString(6);
			while(findChatByID(chatId)) {
				chatId = RandomGenerator.getRandomString(6);
			}
			String chatMembersId = "members" + chatId;
			addNewChat(chatId, chatMembersId);
			
			preparedStatementChat.setObject(1, chatId);
			preparedStatementChat.execute();
			
			
			preparedStatementMembers.setObject(1, chatMembersId);
			preparedStatementMembers.execute();
				
				
				
			return null;
				
			}
					
	}
	
	@SneakyThrows
	public boolean findChatByID (String id){
		try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_CHAT_BY_ID)){
			
			preparedStatement.setObject(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			
			return resultSet.next();
		}
				
	}
	
	@SneakyThrows
	public void addNewChat (String chatId, String chatMembersId ) {
		
		try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_NEW_CHAT)){
			
			preparedStatement.setObject(1, chatId);
			preparedStatement.setObject(1, chatMembersId);
			preparedStatement.executeUpdate();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Chat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Chat> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chat save(Chat entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static ChatDao getInctance () {
		return INCTANCE;
	}

	

}
