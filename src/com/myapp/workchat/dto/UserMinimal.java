package com.myapp.workchat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMinimal {
	
	private Integer id;
	private String firstName;
	private String secondName;
	

}
