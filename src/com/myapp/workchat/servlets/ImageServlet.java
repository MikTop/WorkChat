package com.myapp.workchat.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.myapp.workchat.service.ImageService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

@SuppressWarnings("serial")
@WebServlet("/images/*")
public class ImageServlet  extends HttpServlet{
	
	private final ImageService imageService = ImageService.getInctance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reqUri =  req.getRequestURI().replace("/WorkChat/images", "");
		String windowsReqUri = reqUri.replace("/", "\\");
		
		imageService.getImage(windowsReqUri)
		 .ifPresentOrElse(
				 image -> {
					 resp.setContentType("application/octet-stream");
					 writeImage(image, resp);
				 },
				 () ->resp.setStatus(404));
		
	}
	@SneakyThrows
	private void writeImage(InputStream image, HttpServletResponse resp) {
		
		try(image ;
			OutputStream outputStream = resp.getOutputStream() ){
			int currentByte;
			while((currentByte = image.read()) != -1) {
				outputStream.write(currentByte);
			}
		}
		
	}
}
