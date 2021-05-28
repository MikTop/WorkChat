package com.myapp.workchat.util;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;


@UtilityClass
public class Converter {
	
	public List<Integer> convertStringToInt (List<String> list ){
		List<Integer> resultList = new ArrayList<>();
		for (String s : list) {
			resultList.add(Integer.valueOf(s));
		}
		return resultList;
	}

}
