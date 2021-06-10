package com.myapp.workchat.dao;

import static java.sql.Statement.RETURN_GENERATED_KEYS;
import static lombok.AccessLevel.PRIVATE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.myapp.workchat.entity.Message;
import com.myapp.workchat.util.ConnectionManager;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = PRIVATE)
public class MessageDao implements Dao<Integer, Message> {

	private static final MessageDao INCTANCE = new MessageDao();
	
	private static final String SAVE_MESSAGE_SQL = """
			INSERT INTO message (id, chat_id, message, sender_id, send_date_time)
			VALUES (?, ?, ?, ?, ?)
			""";
	
	private static final String FIND_BY_CHAT_ID_SQL = """
			SELECT id, chat_id, message, sender_id, send_date_time FROM message
			WHERE chat_id = ? 
			""";
	
	@SneakyThrows
	@Override
	public Message save(Message entity) {
		try(Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SAVE_MESSAGE_SQL, RETURN_GENERATED_KEYS)){
			preparedStatement.setObject(1, 0);
			preparedStatement.setObject(2, entity.getChatId());
			preparedStatement.setObject(3, entity.getMessage());
			preparedStatement.setObject(4, entity.getSenderId());
			preparedStatement.setObject(5, entity.getSendDate());
			
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()) {
				entity.setId(resultSet.getLong(1));
				
			}
			
		}
		return entity;
	}
	
	@SneakyThrows
	public List<Message> findByChatId (Integer chatId){
		List<Message> resuList = new ArrayList<>();
		
		try(Connection connection = ConnectionManager.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CHAT_ID_SQL)){
			preparedStatement.setObject(1, chatId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				resuList.add(buildMessage(resultSet));
			}
			
		}
		
		
		return resuList;
	}
	
	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	@Override
	public void update(Integer id) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	








	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Optional<Message> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SneakyThrows
	private Message buildMessage (ResultSet resultSet) {
		return Message.builder()
				.Id(resultSet.getObject("id", Long.class))
				.chatId(resultSet.getObject("chat_id", Integer.class))
				.message(resultSet.getObject("message", String.class))
				.senderId(resultSet.getObject("sender_id", Integer.class))
				.sendDate(resultSet.getObject("send_date_time", LocalDateTime.class))
				.build();
	}


	public static MessageDao getInctance () {
		return INCTANCE;
	}

	
}
