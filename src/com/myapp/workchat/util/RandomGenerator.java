package com.myapp.workchat.util;

import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RandomGenerator {

	public String getRandomString(Integer length) {
		
		char[] allSimbols ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ012345678".toCharArray();
		Random random = new Random(28);
		StringBuilder stringBuilder = new StringBuilder();
		
		for(int i =0; i<length; i++) {
			stringBuilder.append(allSimbols[random.nextInt(allSimbols.length)]);
		}
		
		return stringBuilder.toString();
		
	}
}
