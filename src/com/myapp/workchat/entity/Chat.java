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

	private List<Integer> membersId;
	private String chatName;
	private Integer chatId;
	
	
}
