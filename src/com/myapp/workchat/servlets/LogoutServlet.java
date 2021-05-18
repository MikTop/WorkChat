package com.myapp.workchat.servlets;

import java.io.IOException;

import com.myapp.workchat.util.PropertiesUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		resp.sendRedirect(PropertiesUtil.getProperty("tomcat.apl.path") + "/login");
	}
}
