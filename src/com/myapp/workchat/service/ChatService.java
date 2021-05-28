package com.myapp.workchat.service;

import static lombok.AccessLevel.PRIVATE;

import java.util.List;

import com.myapp.workchat.dao.ChatDao;
import com.myapp.workchat.entity.Chat;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class ChatService {
	
	private static final ChatService INCTANCE = new ChatService();
	
	private static final UserService USER_SERVICE = UserService.getInctance();
	
	private static final ChatDao CHAT_DAO = ChatDao.getInctance();
	
	
	public Chat createNewChat (List<String> membersId) {
		
		CHAT_DAO.
		
		
		return null;
	}
	
	
	
	
	public static ChatService getInctance() {
		return INCTANCE;
	}

}
