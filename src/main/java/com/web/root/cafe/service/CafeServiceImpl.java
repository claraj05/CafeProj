package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

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
		List<CafeDTO> list = null;
		if(locationList[0].contentEquals("0")) {
			String test[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25"};
			list = mapper.getlocationList(test,kidszone,petzone,star);
		}else {
			list = mapper.getlocationList(locationList,kidszone,petzone,star);
		}
		
		model.addAttribute("list",list);
	}


	@Override
	public void cafeAllList(Model model,int num) {
		int pageLetter=5; //한 페이지당 글 개수
		int allCount=mapper.selectcafeCount(); //전체 글수
		
		//ex 전체 글수 10 페이지당 글 개수 3개면, 페이지번호는 4번까지 나와야 함(1개를 위해)
		int repeat = allCount/pageLetter;
		if(allCount%pageLetter !=0) {
			repeat +=1;
		}
		
		int end = num*pageLetter;
		int start = end+1 -pageLetter;
		
		model.addAttribute("repeat",repeat);
		
		model.addAttribute("list",mapper.cafeAllList(start,end));
		System.out.println(mapper.cafeAllList(start,end));
		
	}
	
	
	@Override
	public void eventView(Model model) {
		//이벤트 테이블에서 cafe_no 가져오기
		int arr[] = null;
		arr = mapper.eventCafe();
		/* 잘 들어오나 확인~
		 * for (int i = 0; i < arr.length; i++) {
		 * System.out.println("arr["+i+"] : "+arr[i]); }
		 */
		
		//카페 이미지 테이블에서 cafe_no참조해서 img가져오기(이벤트 화면 보여주는 용으로) 
		
		//이벤트뷰 테이블에서 데이터 가져오기 (이벤트 데이터는 총 4개 가져올거야)
		model.addAttribute("event1",mapper.eventView1());
		model.addAttribute("event2",mapper.eventView2());
		model.addAttribute("event3",mapper.eventView3());
		model.addAttribute("event4",mapper.eventView4());
//		model.addAttribute("eventImg",mapper.eventImageView());
		
	}


	@Override
	public CafeDTO cafeInfo(int cafe_no) {
		// TODO Auto-generated method stub
		return mapper.cafeInfo(cafe_no);
	}

	@Override
	public int writeSave(HttpServletRequest request, CafeDTO dto,
			List<MultipartFile> multiFileList,
			String fileContent, String root) {

		System.out.println("root -> "+root); //root 넘어오는 해결1
		/* System.out.println(mul); */
		// request.getParameter("cafe_no");
		// 여기 문제 cafe_name

 
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
//			mapper.writeSave2(dto.getCafe_no(), root, multiFileList.get(i).getOriginalFilename(), fileContent);
		}
		return result;

	}
	
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
//				result+= mapper.writeSave2(cafe_no, imgLocation,multiFileList.get(i).getOriginalFilename(),  fileContent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

		}

}
