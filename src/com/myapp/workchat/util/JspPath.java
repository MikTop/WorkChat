package com.myapp.workchat.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JspPath {

	public static String getPath (String name) {
		return String.format("/WEB-INF/jsp/%s.jsp", name);
	}
	
	
	
}

