package com.web.root.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.cafe.dto.CafeDTO;

import com.web.root.cafe.dto.CafeDTO;

public interface CafeService {

	public void getlocationList(HttpServletRequest request, 
			@RequestParam("locationList") String [] locationList,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model);
	
	public void getlocationListA(HttpServletRequest request, 
			@RequestParam("all") int all,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model);
	
	public void cafeAllList(Model model);
	
<<<<<<< HEAD
	
	public CafeDTO cafeInfo(int cafe_no);
=======
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request, CafeDTO dto);
	
>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
}
