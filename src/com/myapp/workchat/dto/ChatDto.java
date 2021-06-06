package com.myapp.workchat.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChatDto {
	
	List<UserMinimal> chatsMembers;
	String chatName;
	Integer chatId;
}
