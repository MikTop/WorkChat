package com.myapp.workchat.service;

import static lombok.AccessLevel.PRIVATE;

import java.util.ArrayList;
import java.util.List;

import com.myapp.workchat.dao.MessageDao;
import com.myapp.workchat.entity.Message;
import com.myapp.workchat.util.MessageCollectionSort;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class MessageService {

	private static final MessageService INCTANCE = new MessageService();
	
	private final MessageDao messageDao = MessageDao.getInctance();
	
	public void saveMessage (Message message) {
		messageDao.save(message);
	}
	
	public List<Message> getListByChatId (Integer chatId){
		List<Message> messages = new ArrayList<>();
		
		messages.addAll(messageDao.findByChatId(chatId));
		MessageCollectionSort.sortMessageByDate(messages);
		
		return messages;
	}
	
	
	
	
	
	
	public static MessageService getInctance () {
		return INCTANCE;
	}
}
