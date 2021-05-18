package com.myapp.workchat.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LocalDateFormatter {
	
	private static final String PATTERN = "yyyy-MM-dd";
	
	private static final DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern(PATTERN);
	
	public LocalDate format (String date) {
		return LocalDate.parse(date, dFormatter);
	}
	

}
