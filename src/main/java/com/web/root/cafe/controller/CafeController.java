package com.web.root.cafe.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.file.service.BoardFileService;
import com.web.root.cafe.service.CafeService;

@Controller
@RequestMapping("cafe")
public class CafeController {
	
	@Autowired
	CafeService cf;
	
	
	
	@GetMapping("searchView")
	public String searchView() {
		return "cafe/searchView";
	}
	
	@GetMapping("eventView")
	public String eventView() {
		return "cafe/eventView";
	}
	
	@GetMapping("mycafe")
	public String mycafe() {
		return "cafe/mycafe";
	}
	
	
	@GetMapping("searchResult")
	public String searchResult(HttpServletRequest request, 
			@RequestParam("location1") String[] location1, 
			@RequestParam("kidszone") String kidszone, 
			@RequestParam("petzone") String petzone,
			@RequestParam("star")String star,Model model) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String [] locationList =  request.getParameterValues("location1");
		kidszone = request.getParameter("kidszone");
		petzone = request.getParameter("petzone");
		star = request.getParameter("star");
		if(locationList[0]=="0") {
			int all = 0;
			cf.getlocationListA(request, all, kidszone, petzone, star, model);
		}
		cf.getlocationList(request,locationList, kidszone, petzone, star, model);
		return "cafe/searchResult";
	}
	
	@GetMapping("cafeAllList")
	public String test(HttpServletRequest request, Model model) {
		cf.cafeAllList(model);
		return "cafe/cafeAllList";
	}
	
	
	  @PostMapping("writeSave") 
	  public void writeSave(MultipartHttpServletRequest
			  				mul, HttpServletResponse response,
			  				HttpServletRequest request, CafeDTO dto) throws IOException {
	  
	  String message = cf.writeSave(mul, request, dto);
	  
	  PrintWriter out = response.getWriter();
	  response.setContentType("text/html; charset=utf-8");
	  out.print(message);
	  }
	 
	 


	
}





















