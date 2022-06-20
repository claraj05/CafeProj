package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.upload.dto.UploadDTO;

public interface CafeService {
	
	public void searchEng(String searchKW, Model model);
	public void getlocationList(HttpServletRequest request, 
			@RequestParam("locationList") String [] locationList,@RequestParam("kidszone")String kidszone,
			@RequestParam("petzone")String petzone,
			@RequestParam("star")String star,Model model);
	
	public void cafeAllList(Model model, int num);
	public String getImgRoot(int cafe_no);
	public String getImgFirstName(int cafe_no);
	public void uploadImage(Model model);
	
	public void eventView(Model model);
	
	public CafeDTO cafeInfo(int cafe_no);
	
	
	public int writeSave(HttpServletRequest request, CafeDTO dto, List<MultipartFile> multiFileList,
			String fileContent, String root);
	

	public int checkLike(String id,int cafe_no);
	public int plusLike(String id,int cafe_no);
	public int minusLike(String id,int cafe_no);
	public int countplus(int cafe_no);
	public int countminus(int cafe_no);
	/*
	 * public int writeSave2(HttpServletRequest request, List<MultipartFile>
	 * multiFileList, String fileContent);
	 */


}
