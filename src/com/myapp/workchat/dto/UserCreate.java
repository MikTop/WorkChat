package com.myapp.workchat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreate {
	
		
		
		private String firstName;
		private String secondName;
		private String email;
		private String password;
		private String image;
		private String birthday;
		private String role;
}

