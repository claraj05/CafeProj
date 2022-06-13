package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.mybatis.cafe.CafeMapper;
@Service
public class CafeServiceImpl implements CafeService{
	
	
	@Autowired
	CafeMapper mapper;
	
	
	@Override
	public void getlocationList(HttpServletRequest request, 
			String [] locationList, 
			String kidszone,
			String petzone, 
			String star,
			Model model) {
		//check
		locationList = request.getParameterValues("location1");
		kidszone = request.getParameter("kidszone");
		petzone = request.getParameter("petzone");
		List<CafeDTO> list = mapper.getlocationList(locationList,kidszone,petzone,star);
		
		model.addAttribute("list",list);
	}


	@Override
	public void cafeAllList(Model model) {
		model.addAttribute("list",mapper.cafeAllList());
		System.out.println(mapper.cafeAllList());
	}


	
	
	
	
}
