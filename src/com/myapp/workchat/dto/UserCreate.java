package com.myapp.workchat.dto;

import jakarta.servlet.http.Part;
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
		private Part image;
		private String birthday;
		private String role;
}

