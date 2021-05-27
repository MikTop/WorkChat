package com.myapp.workchat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
	
	private Long Id;
	private String message;
	private Integer sender;
	private String chatName;
	

}
