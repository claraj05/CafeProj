package com.web.root.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface CafeService {

	public void getlocationList(HttpServletRequest request, 
			@RequestParam("locationList") String [] locationList,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model);
	
	public void cafeAllList(Model model);
}
