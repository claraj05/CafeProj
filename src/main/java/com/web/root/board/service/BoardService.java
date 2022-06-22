package com.web.root.board.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {
	
	public String path="C:\\Boardimg";
	
	public void boardWrite(MultipartHttpServletRequest mul);
	
	public void boardList(Model model, int currentPage);
	
	public void boardView(Model model, int write_no);
	
	public void boardModify(MultipartHttpServletRequest mul);
	
	public void boardDelete(int write_no);
	
	public void upHit(int write_no);
	
	public void boardSearch(Model model, String searchList, String search, int currentPage);
	
	public int boardLike(HttpServletRequest request); 
	
	public void likeMinus(HttpServletRequest request);
	public void likePlus(HttpServletRequest request);
	
	public void likeCountMinus(HttpServletRequest request);
	public void likeCountPlus(HttpServletRequest request);
}












