package com.myapp.workchat.service;

import static lombok.AccessLevel.PRIVATE;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.myapp.workchat.dao.ChatDao;
import com.myapp.workchat.dto.ChatDto;
import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.entity.Chat;
import com.myapp.workchat.entity.User;
import com.myapp.workchat.mappers.ChatDtoMapper;
import com.myapp.workchat.util.Converter;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class ChatService {
	
	private static final ChatService INCTANCE = new ChatService();
	
	private final UserService userService = UserService.getInctance();
	
	private final ChatDao chatDao = ChatDao.getInctance();
	private final ChatDtoMapper chatDtoMapper = ChatDtoMapper.getInctance();
	
	
	public void createNewChat (List<String> membersId) {
		
		List<Integer> chatMembers  = Converter.convertStringToInt(membersId);
		chatDao.createChat(chatMembers);
			
		
	}
	public List<ChatDto> getUserChats (Integer userId){
		List<Integer> chatsId = chatDao.findChatsByMemberId(userId);
		
		return chatsId.stream()
				.map(chat -> Chat.builder().chatId(chat).membersId(chatDao.findMembersByChatId(chat)).build())
				.map(chat -> chatDtoMapper.mapTo(chat))
				.collect(Collectors.toList());
		
		
		
	}
	
	
	
	
	public static ChatService getInctance() {
		return INCTANCE;
	}

}
