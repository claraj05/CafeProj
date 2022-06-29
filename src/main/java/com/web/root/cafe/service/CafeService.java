package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.upload.dto.UploadDTO;

public interface CafeService {
	
	
	public void searchEng(String searchKW, Model model, int num);
	public void searchEngS(String searchKW, Model model, int num);
	public void getlocationList(HttpServletRequest request, 
			@RequestParam("locationList") String [] locationList,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model, int num);
	
	
	public void cafeAllList(Model model, int num);
	public void cafeAllListS(Model model, int num);
	
	public void eventView(Model model);
	
	public CafeDTO cafeInfo(int cafe_no);
	
	public boolean cafeWrite(CafeDTO dto,String imgContent,List<MultipartFile> multiFiles);

	public int cafeSelect(HttpServletRequest request);
	
	public void selectMinus(HttpServletRequest request);
	public void selectPlus(HttpServletRequest request);
	public void selectCountMinus(HttpServletRequest request);
	public void selectCountPlus(HttpServletRequest request);
	public void getSelectList(Model model, String id, int num);
	

}
