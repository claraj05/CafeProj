package com.web.root.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.cafe.dto.CafeDTO;

import com.web.root.cafe.dto.CafeDTO;

public interface CafeService {

	public void getlocationList(HttpServletRequest request, @RequestParam("locationList") String[] locationList,
			@RequestParam("kidszone") String kidszone, @RequestParam("petzone") String petzone,
			@RequestParam("star") String star, Model model);

	public void cafeAllList(Model model, int num);

	public void eventView(Model model);

	public CafeDTO cafeInfo(int cafe_no);

	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request, CafeDTO dto);

}
