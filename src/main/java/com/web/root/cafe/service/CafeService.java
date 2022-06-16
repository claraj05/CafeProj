package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;

public interface CafeService {

	public void getlocationList(HttpServletRequest request, 
			@RequestParam("locationList") String [] locationList,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model);
	
	public void cafeAllList(Model model, int num);
	
	public void eventView(Model model);
	
	
	public CafeDTO cafeInfo(int cafe_no);
	
	
	public int writeSave(HttpServletRequest request, CafeDTO dto,List<MultipartFile> multiFileList,
			String fileContent, String root);
	
	public int writeSave2(int cafe_no, HttpServletRequest request, List<MultipartFile> multiFileList,
			String fileContent);

	int selectno(CafeDTO dto, HttpServletRequest request, List<MultipartFile> multiFileList, String fileContent);

}
