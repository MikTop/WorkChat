package com.myapp.workchat.util;

import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RandomGenerator {
	private final Random random = new Random(28);
	public String getRandomString(Integer length) {
		
		char[] allSimbols ="abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i =0; i<length; i++) {
			stringBuilder.append(allSimbols[random.nextInt(allSimbols.length)]);
		}
		System.out.println(stringBuilder);
		return stringBuilder.toString();
		
	}
	public Integer getRandomint () {
		return random.nextInt();
	}
	
}
