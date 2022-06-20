package com.web.root.cafe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.file.service.CafeFileService;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.cafe.CafeMapper;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeMapper mapper;

	@Autowired
	CafeFileService bfs;

	
	@Override
	public void searchEng(String searchKW, Model model) {
		model.addAttribute("kwResult",mapper.searchEng(searchKW));
		
	}

	//검색필터로 검색하기 기능
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

	//전체 카페 리스트 보여주기 기능
	@Override
	public void cafeAllList(Model model,int num) {
		int pageLetter=5; //한 페이지당 글 개수
		int allCount=mapper.selectcafeCount(); //전체 글수
		
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
	public void uploadImage(Model model) {
		model.addAttribute("img",mapper.cafeImageLoad());
	}

	@Override
	public String getImgRoot(int cafe_no) {
		String root = mapper.getImgRoot(cafe_no);
		System.out.println("root : "+root);
		return root;
	}

	@Override
	public String getImgFirstName(int cafe_no) {
		String [] images = mapper.getImage(cafe_no);
		String firstImage = null;
		try {
			if(images!=null) {
				firstImage = images[0];
			}
			return firstImage;
		} catch (Exception e) {
			return "실패";
		}
	}

	//이벤트 db 불러오기 기능
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

	//카페 정보 불러오기
	@Override
	public CafeDTO cafeInfo(int cafe_no) {
		// TODO Auto-generated method stub
		return mapper.cafeInfo(cafe_no);
	}
	
	//카페 정보 저장하기
	@Override
	public int writeSave(HttpServletRequest request, CafeDTO dto,
			List<MultipartFile> multiFileList,
			String imgContent, String root) {

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
			Integer cafe_no = mapper.selectNo(dto);
			System.out.println("cafe_no : "+ cafe_no);
			mapper.writeSave2(root, multiFileList.get(i).getOriginalFilename(), imgContent);
		}
		return result;

	}

	
	//카페 좋아요 기능 
	@Override
	public int checkLike(String id, int cafe_no) {
		int result = mapper.checkLike(id,cafe_no);
//		System.out.println("check result"+result);
		return result;
	}

	@Override
	public int plusLike(String id, int cafe_no) {
		int result = mapper.plusLike(id, cafe_no);
		System.out.println("result(+) = "+result);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int minusLike(String id, int cafe_no) {
		int result = mapper.minusLike(id, cafe_no);
		System.out.println("result(-) = "+result);
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public int countplus(int cafe_no) {
		int result = mapper.countplus(cafe_no);
		return result;
	}


	@Override
	public int countminus(int cafe_no) {
		int result = mapper.countminus(cafe_no);
		return result;
	}

	
	
	
	
	
	/*
	 * @Override public int writeSave2(HttpServletRequest request,
	 * List<MultipartFile> multiFileList, String imgContent) { String
	 * imgLocation=null; int result = 0; try { for (int i = 0; i <
	 * multiFileList.size(); i++) { //mapper.writeSave2로 넘길 데이터 : originFileName,
	 * root, cafe_no, fileContent result+= mapper.writeSave2(cafe_no,
	 * imgLocation,multiFileList.get(i).getOriginalFilename(), fileContent); } }
	 * catch (Exception e) { e.printStackTrace(); } return result;
	 * 
	 * }
	 */

}
