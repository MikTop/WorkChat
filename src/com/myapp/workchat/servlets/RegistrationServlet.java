package com.myapp.workchat.servlets;

import java.io.IOException;

import com.myapp.workchat.dto.UserCreate;
import com.myapp.workchat.entity.Role;
import com.myapp.workchat.service.UserService;
import com.myapp.workchat.util.JspPath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@MultipartConfig(fileSizeThreshold = 1024*1024)
@SuppressWarnings("serial")
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

	private final UserService userService = UserService.getInctance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles", Role.values());
		
		req.getRequestDispatcher(JspPath.getPath("registration"))
		.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException  {
		
		UserCreate user = UserCreate.builder()
				.firstName(req.getParameter("firstName"))
				.secondName(req.getParameter("secondName"))
				.email(req.getParameter("email"))
				.password(req.getParameter("password"))
				.birthday(req.getParameter("birthday"))
				.role(req.getParameter("role"))
				.image(req.getPart("image"))
				.build();
		
		userService.createUser(user);
		
		try {
			resp.sendRedirect("/WorkChat/login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	
	

}
