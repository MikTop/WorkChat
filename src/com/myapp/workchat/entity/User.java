package com.myapp.workchat.entity;

import java.time.LocalDate;

import lombok.Data;

@Data
public class User {
	private Integer id;
	private String firstName;
	private String secondName;
	private String email;
	private String password;
	private String image;
	private LocalDate birthday;
}
