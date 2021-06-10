package com.myapp.workchat.entity;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	private Integer id;
	private String firstName;
	private String secondName;
	private String email;
	private String password;
	private String image;
	private LocalDate birthday;
	private Role role;
	
}
