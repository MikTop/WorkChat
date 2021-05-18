package com.myapp.workchat.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.myapp.workchat.entity.Role;
import com.myapp.workchat.util.JspPath;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ChatServlets extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			req.setAttribute("roles", Role.values());
			req.getRequestDispatcher(JspPath.getPath("registration"))
			.forward(req, resp);
		}
		
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	
	

}
