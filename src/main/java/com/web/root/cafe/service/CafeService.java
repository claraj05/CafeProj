package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.cafe.dto.CafeDTO;

public interface CafeService {

	public void getlocationList(HttpServletRequest request, 
			@RequestParam("locationList") String [] locationList,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model);
	
	public void cafeAllList(Model model);
	
	/*
	 * public String writeSave(HttpServletResponse response, CafeDTO dto,
	 * 
	 * @RequestParam("multiFile") List<MultipartFile> multiFileList,
	 * 
	 * @RequestParam String fileContent, HttpServletRequest request);
	 */

	public String writeSave(HttpServletRequest request, CafeDTO dto, List<MultipartFile> multiFileList,
			String fileContent);
	
}
