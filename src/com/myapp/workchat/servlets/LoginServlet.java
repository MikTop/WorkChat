package com.myapp.workchat.servlets;

import java.io.IOException;

import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.service.UserService;
import com.myapp.workchat.util.JspPath;
import com.myapp.workchat.util.PropertiesUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private final UserService userService = UserService.getInctance();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspPath.getPath("login"))
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		userService.getUserByEmailAndPassword(req.getParameter("email"), req.getParameter("password"))
		.ifPresentOrElse(user -> onLoginSuccess(user, req, resp), () -> onLoginFail(req, resp));
		
	}
	@SneakyThrows
	private void onLoginSuccess(UserDto user, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", user);
		response.sendRedirect(PropertiesUtil.getProperty("tomcat.apl.path") + "/profile");
	}
	@SneakyThrows
	private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
		resp.sendRedirect(PropertiesUtil.getProperty("tomcat.apl.path") + "/login?error&email=" + req.getParameter("email"));
	}
}
