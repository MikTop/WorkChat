package com.myapp.workchat.util;

import java.sql.Connection;
import java.sql.DriverManager;


import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConnectionManager {
	
	private final static String URL_KEY = "db.url";
	private final static String USERNAME_KEY = "db.username";
	private final static String PASSWORD_KEY = "db.password";
	
	
	static {
		loaddriver();
	}
	
	@SneakyThrows
	public Connection openConnection (){
		return DriverManager.getConnection(PropertiesUtil.getProperty(URL_KEY), 
				PropertiesUtil.getProperty(USERNAME_KEY), 
				PropertiesUtil.getProperty(PASSWORD_KEY));
	}

	@SneakyThrows
	private static void loaddriver() {
		
			Class.forName("com.mysql.cj.jdbc.Driver.class");
		
		
	}
}
