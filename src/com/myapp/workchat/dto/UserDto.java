package com.myapp.workchat.dto;

import java.time.LocalDate;

import com.myapp.workchat.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
	
	private Integer id;
	private String firstName;
	private String secondName;
	private String email;
	private String image;
	private LocalDate birthday;
	private Role role;
}
