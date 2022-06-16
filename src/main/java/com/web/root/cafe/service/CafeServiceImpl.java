package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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
	public String writeSave(MultipartHttpServletRequest mul, HttpServletRequest request, CafeDTO dto) {

		System.out.println(mul);
		// request.getParameter("cafe_no");
		// 여기 문제 cafe_name

		int result = 0;
		try {
			result = mapper.writeSave(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String msg, url;
		if (result == 1) {
			msg = "새글이 등록 되었습니다..";
			url = "/cafe/cafeAllList";
		} else {
			msg = "문제가 발생했습니다..";
			url = "/cafe/cafemanager";
		}

		return bfs.getMessage(request, msg, url);

	}

}
