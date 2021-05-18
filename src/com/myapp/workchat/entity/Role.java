package com.myapp.workchat.entity;

import java.util.Arrays;
import java.util.Optional;

public enum Role {
	Admin, 
	User, 
	Developer;
	
	public static Optional<Role> find(String role) {
		return Arrays.stream(Role.values())
				.filter(it-> it.name().equals(role))
				.findFirst();
	}
	
	
}

