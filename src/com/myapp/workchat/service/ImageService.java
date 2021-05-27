package com.myapp.workchat.service;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;
import static lombok.AccessLevel.PRIVATE;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

import com.myapp.workchat.util.PropertiesUtil;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = PRIVATE)
public class ImageService {
	
	private static final ImageService INCTANCE = new ImageService();
	private static final String IMAGEBASEPATH = PropertiesUtil.getProperty("image.base.path");
	
	@SneakyThrows
	public void saveImage(String imagePath, InputStream imageContent) {
		Path imageFullPath = Path.of(IMAGEBASEPATH, imagePath);
		try(imageContent) {
			Files.createDirectories(imageFullPath.getParent());
			Files.write(imageFullPath, imageContent.readAllBytes(), CREATE, TRUNCATE_EXISTING );
		}
		
	}
	
	@SneakyThrows
	public Optional<InputStream> getImage(String imagePath){
		
		Path imageFullPath = Path.of(IMAGEBASEPATH, imagePath);
		
		return Files.exists(imageFullPath) 
				? Optional.of(Files.newInputStream(imageFullPath))
				: Optional.empty();
	}
	
	
	
	
	
	public static ImageService getInctance() {
		return INCTANCE;
	}

}
