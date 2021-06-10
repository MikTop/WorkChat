package com.myapp.workchat.servlets;

import java.io.IOException;
import java.time.LocalDateTime;

import com.myapp.workchat.dto.UserDto;
import com.myapp.workchat.entity.Message;
import com.myapp.workchat.service.MessageService;
import com.myapp.workchat.util.JspPath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	
	

	private static final long serialVersionUID = 1L;
	private final MessageService messageService = MessageService.getInctance();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer chatId = Integer.valueOf(req.getParameter("chatId"));
		req.setAttribute("messages", messageService.getListByChatId(chatId));
		req.setAttribute("chatId", chatId);
		req.getRequestDispatcher(JspPath.getPath("chat"))
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer chatId = Integer.valueOf( req.getParameter("chatId"));
			
			Message message = Message.builder()
					.chatId(chatId)
					.Id(0L)
					.message(req.getParameter("newMessage"))
					.senderId(((UserDto)req.getSession().getAttribute("user")).getId())
					.sendDate(LocalDateTime.now())
					.build();
			
			messageService.saveMessage(message);
			doGet(req, resp);
			}

}
