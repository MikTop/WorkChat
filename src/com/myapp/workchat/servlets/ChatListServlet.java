package com.myapp.workchat.servlets;

import java.io.IOException;

import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.entity.User;
import com.myapp.workchat.service.ChatService;
import com.myapp.workchat.util.JspPath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/chatList")
public class ChatListServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final ChatService chatService = ChatService.getInctance();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDto user = (UserDto) req.getSession().getAttribute("user");
		req.setAttribute("chats", chatService.getUserChats(user.getId()));
		
		req.getRequestDispatcher(JspPath.getPath("chatList")).forward(req, resp);
		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
