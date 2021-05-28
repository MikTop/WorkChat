package com.myapp.workchat.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.myapp.workchat.service.UserService;
import com.myapp.workchat.util.JspPath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createChat")
public class CreateChatServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final UserService  USER_SERVICE = UserService.getInctance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("users", USER_SERVICE.findAll());
		
		req.getRequestDispatcher(JspPath.getPath("createChat"))
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> chatMembersId =  Arrays.asList(req.getParameterValues("chatMembers"));
	}
	

}
