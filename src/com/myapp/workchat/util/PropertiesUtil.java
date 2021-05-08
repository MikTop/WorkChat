package com.myapp.workchat.util;

import java.io.InputStream;

import java.util.Properties;



import lombok.experimental.UtilityClass;


@UtilityClass
public class PropertiesUtil {

	private final static Properties INSTANCE = new Properties();
	
	static {
		loadProperties();
	}
	
	public String getProperty (String key) {
		return INSTANCE.getProperty(key);
	}
	
	public void loadProperties() {
		try (InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream("aplication.properties");){
			
			INSTANCE.load(inputStream);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
