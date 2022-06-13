package com.web.root.cafe.file.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {

	
public void boardAllList(Model model, int num);
	
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request);
	
	public void contentView(int writeNo, Model model);
	
	public String modify(MultipartHttpServletRequest mul, HttpServletRequest request);
	
	public String boardDelete(int writeNo, String imageFileName, HttpServletRequest request);
	
}
