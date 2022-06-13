package com.web.root.cafe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			@RequestParam("location1") String location1, 
			@RequestParam("kidszone") String kidszone, 
			@RequestParam("petzone") String petzone,
			@RequestParam("star")String star,Model model) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String [] locationList =  request.getParameterValues("location1");
		kidszone = request.getParameter("kidszone");
		petzone = request.getParameter("petzone");
		star = request.getParameter("star");
		cf.getlocationList(request,locationList, kidszone, petzone, star, model);
		return "cafe/searchResult";
	}
	
	@GetMapping("cafeAllList")
	public String test(HttpServletRequest request, Model model) {
		cf.cafeAllList(model);
		return "cafe/cafeAllList";
	}
	
}





















