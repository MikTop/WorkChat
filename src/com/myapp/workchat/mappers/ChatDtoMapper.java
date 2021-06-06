package com.myapp.workchat.mappers;

import static lombok.AccessLevel.PRIVATE;

import com.myapp.workchat.dto.ChatDto;
import com.myapp.workchat.entity.Chat;
import com.myapp.workchat.service.UserService;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PRIVATE)
public class ChatDtoMapper {
	
	private static final ChatDtoMapper INCTANCE = new ChatDtoMapper();
	
	private final UserService userService = UserService.getInctance();
	
	public ChatDto mapTo (Chat chat) {
		
		return ChatDto.builder()
				.chatId(chat.getChatId())
				.chatsMembers(userService.findByIdList(chat.getMembersId()))
				.build();
				
	}
	
	
	
	
	
	public static ChatDtoMapper getInctance() {
		return INCTANCE;
	}
}
