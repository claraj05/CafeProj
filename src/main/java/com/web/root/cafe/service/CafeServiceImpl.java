package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.file.service.BoardFileService;
import com.web.root.mybatis.cafe.CafeMapper;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeMapper mapper;

	@Autowired
	BoardFileService bfs;

	@Override
	public void getlocationList(HttpServletRequest request, String[] locationList, String kidszone, String petzone,
			String star, Model model) {
		// check
		String[] locationList1 = locationList;
		kidszone = request.getParameter("kidszone");
		petzone = request.getParameter("petzone");
		List<CafeDTO> list = mapper.getlocationList(locationList, kidszone, petzone, star);

		model.addAttribute("list", list);
	}

	@Override
<<<<<<< HEAD
=======
	public void getlocationListA(HttpServletRequest request, int all, String kidszone, String petzone, String star,
			Model model) {
		all = 0;
		List<CafeDTO> list = mapper.getlocationListA(all, kidszone, petzone, star);

		model.addAttribute("list", list);
	}

	@Override
>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
	public void cafeAllList(Model model) {
		model.addAttribute("list", mapper.cafeAllList());
		System.out.println(mapper.cafeAllList());
	}
<<<<<<< HEAD
	
=======

	@Override
	public CafeDTO cafeInfo(int cafe_no) {
		// TODO Auto-generated method stub
		return mapper.cafeInfo(cafe_no);
	}

>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
	@Override
<<<<<<< HEAD
	   public CafeDTO cafeInfo(int cafe_no) {
	      // TODO Auto-generated method stub
	      return mapper.cafeInfo(cafe_no);
	   }

	@Override
	public int writeSave(HttpServletRequest request, CafeDTO dto,
			List<MultipartFile> multiFileList,
			String fileContent, String root) {
=======
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request, CafeDTO dto) {
>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git

		System.out.println("root -> "+root); //root 넘어오는 해결1
		/* System.out.println(mul); */
		// request.getParameter("cafe_no");
		// 여기 문제 cafe_name

<<<<<<< HEAD
 
=======
>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
		int result = 0;
		try {
			result = mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		String msg, url;
//		if (result == 1) {
//			msg = "새글이 등록 되었습니다..";
//			url = "/cafe/cafemanager";
//		} else {
//			msg = "문제가 발생했습니다..";
//			url = "/cafe/cafemanager";
//		}
		for (int i = 0; i < multiFileList.size(); i++) {
			mapper.writeSave2(dto.getCafe_no(), root, multiFileList.get(i).getOriginalFilename(), fileContent);
		}
		return result;
		
		
		

	}

<<<<<<< HEAD
	@Override
	public int selectno(CafeDTO dto, HttpServletRequest request, List<MultipartFile> multiFileList,String fileContent) {
		int cafe_no = mapper.selectNo(dto); //cafe_no 넘어오는 거 해결2
		System.out.println(cafe_no);
		int result2 = writeSave2(cafe_no, request, multiFileList, fileContent);
		return result2;
	}

	@Override
	public int writeSave2(int cafe_no, HttpServletRequest request, List<MultipartFile> multiFileList,
			String fileContent) {
		String imgLocation=null;
		int result = 0;
		try {
			for (int i = 0; i < multiFileList.size(); i++) {
				//mapper.writeSave2로 넘길 데이터 : originFileName, root, cafe_no, fileContent
				result+= mapper.writeSave2(cafe_no, imgLocation,multiFileList.get(i).getOriginalFilename(),  fileContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		String msg, url;
//		if (result == 1) {
//			msg = "새글이 등록 되었습니다..";
//			url = "/cafe/cafemanager";
//		} else {
//			msg = "문제가 발생했습니다..";
//			url = "/cafe/cafemanager";
//		}
		
		return result;

	}

	
	
	
=======
>>>>>>> branch 'master' of https://github.com/claraj05/CafeProj.git
}



















