package com.web.root.cafe.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardFileService {

	public static final String IMAGE_REPO = "D:/java_stack/Spring/cafe_image_repo";

	public String saveFile(MultipartFile file);
	
	public String getMessage(HttpServletRequest request, String msg, String url);
	
	public void deleteImage(String originFileName);
	
}
