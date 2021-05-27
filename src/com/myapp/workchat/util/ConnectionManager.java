package com.myapp.workchat.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.mysql.cj.jdbc.Driver;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ConnectionManager {
	
	
	
	private final static String URL_KEY = "db.url";
	private final static String USERNAME_KEY = "db.username";
	private final static String PASSWORD_KEY = "db.password";
	
	private final Integer POOL_SIZE = 10;
	
	private static BlockingQueue<Connection> pool;
	private static List<Connection> connections;
	
	
	static {
		loaddriver();
		initPoolConnection();
	}
	
	private static void initPoolConnection () {
		
		pool = new ArrayBlockingQueue<>(POOL_SIZE);
		connections = new ArrayList<>();
		
		for (int i = 0; i < POOL_SIZE; i++) {
			Connection connection = openConnection();			
			Connection proxyConnection = (Connection)Proxy.newProxyInstance(ConnectionManager.class.getClassLoader(),
					new Class[] {Connection.class}, 
					(InvocationHandler) (proxy, method, args) -> 
				(method.getName().equals("close")) 
				? pool.add((Connection)proxy)
				: method.invoke(connection, args));
			
			pool.add(proxyConnection);
			connections.add(connection);								
		}
	}
	
	@SneakyThrows
	public void closePool() {
		for(Connection connection : connections) {
			connection.close();
		}
	}
	
	@SneakyThrows
	public Connection getConnection() {
		
			return pool.take();
		
	}
	
	@SneakyThrows
	private Connection openConnection (){
		return DriverManager.getConnection(PropertiesUtil.getProperty(URL_KEY), 
				PropertiesUtil.getProperty(USERNAME_KEY), 
				PropertiesUtil.getProperty(PASSWORD_KEY));
	}

	@SneakyThrows
	private static void loaddriver() {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
	}
}
