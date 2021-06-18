package com.myapp.workchat.filter;

import java.io.IOException;
import java.util.Set;

import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.util.PropertiesUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@WebFilter("/*")
public class AuthorizationFilter implements Filter{
	
	
	public static final Set<String> PUBLIC_PATH = Set.of("/login", "/registration", "/");

	@SneakyThrows
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
		String uri = ((HttpServletRequest)request).getRequestURI();
		
			if(isPublicPath(uri) || isUserLogged(request) ) {
				chain.doFilter(request, response);
			}else {
				String prevPage = ((HttpServletRequest)request).getHeader("referer");
				((HttpServletResponse)response)
				.sendRedirect(PropertiesUtil.getProperty("tomcat.apl.path") + prevPage != null ? prevPage : "/login");
			}
	}

	private boolean isUserLogged(ServletRequest request) {
		UserDto user = (UserDto) ((HttpServletRequest)request).getSession().getAttribute("user");
		return user != null;
	}

	private boolean isPublicPath(String uri) {
		String prepUri = uri.replaceAll(PropertiesUtil.getProperty("tomcat.apl.path").toString(), "");
		return PUBLIC_PATH.stream().anyMatch(path -> path.startsWith(prepUri));
	}

}
