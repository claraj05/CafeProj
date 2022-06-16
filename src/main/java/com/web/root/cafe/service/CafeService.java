package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;

public interface CafeService {

<<<<<<< HEAD
	public void getlocationList(HttpServletRequest request, 
			@RequestParam("locationList") String [] locationList,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model);
	
=======
	public void getlocationList(HttpServletRequest request, @RequestParam("locationList") String[] locationList,
			@RequestParam("kidszone") String kidszone, @RequestParam("petzone") String petzone,
			@RequestParam("star") String star, Model model);

	public void getlocationListA(HttpServletRequest request, @RequestParam("all") int all,
			@RequestParam("kidszone") String kidszone, @RequestParam("petzone") String petzone,
			@RequestParam("star") String star, Model model);

>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
	public void cafeAllList(Model model);
<<<<<<< HEAD
	
	/*
	 * public String writeSave(HttpServletResponse response, CafeDTO dto,
	 * 
	 * @RequestParam("multiFile") List<MultipartFile> multiFileList,
	 * 
	 * @RequestParam String fileContent, HttpServletRequest request);
	 */
	
=======

>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
	public CafeDTO cafeInfo(int cafe_no);
<<<<<<< HEAD
	
	
	public int writeSave(HttpServletRequest request, CafeDTO dto,List<MultipartFile> multiFileList,
			String fileContent, String root);
	
	public int writeSave2(int cafe_no, HttpServletRequest request, List<MultipartFile> multiFileList,
			String fileContent);

	int selectno(CafeDTO dto, HttpServletRequest request, List<MultipartFile> multiFileList, String fileContent);
	
	
=======

	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request, CafeDTO dto);

>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
}















