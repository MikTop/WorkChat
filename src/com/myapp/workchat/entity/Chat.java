package com.myapp.workchat.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chat {

	private List<User> chatMembers;
	private String chatName;
	private List<Message> messages;
	
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	
	public void addMember(User user) {
		this.chatMembers.add(user);
	}
	
	public void deleteMember(User user) {
		this.chatMembers.remove(user);
	}
	
}
