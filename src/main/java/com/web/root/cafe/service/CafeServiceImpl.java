package com.web.root.cafe.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.dto.CafeListDTO;
import com.web.root.cafe.dto.EventViewDTO;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.cafe.CafeMapper;

@Service
public class CafeServiceImpl implements CafeService {

	@Autowired
	private CafeMapper mapper;

	@Autowired
	CafeFileService fileService;

	@Override
	public void searchEng(String searchKW, Model model) {
		
		List<CafeListDTO> view = new ArrayList<CafeListDTO>();
		List<CafeDTO> dto = mapper.searchEng(searchKW);
		for (int i = 0; i < dto.size(); i++) {
			UploadDTO cafeListDTO = mapper.findCafeImage(mapper.searchEng(searchKW).get(i).getCafe_no()).get(0);
			System.out.println(cafeListDTO);
			CafeDTO cafeDTO = dto.get(i); 
			view.add(new CafeListDTO(cafeDTO.getCafe_no(),
					cafeDTO.getCafe_name(), cafeListDTO.getImgName(), cafeDTO.getAvg_star(),
					cafeDTO.getLocation2(), cafeDTO.getKidszone(), cafeDTO.getPetzone(),
					cafeDTO.getUse_time(), cafeDTO.getSelect_count(),
					cafeListDTO.getImgLocation()));
		}
		try {
			model.addAttribute("list", view);
			System.out.println("값 model에 추가 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mapper.searchEng실패");
		}

	}

	// 검색필터로 검색하기 기능
	@Override
	public void getlocationList(HttpServletRequest request, String[] locationList, String kidszone, String petzone,
			String star, Model model) {
		// check
		locationList = request.getParameterValues("location1");
		kidszone = request.getParameter("kidszone");
		petzone = request.getParameter("petzone");
		List<CafeDTO> list = null;
		if (locationList[0].contentEquals("0")) {
			String def[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
					"17", "18", "19", "20", "21", "22", "23", "24", "25" };
			list = mapper.getlocationList(def, kidszone, petzone, star);
		} else {
			list = mapper.getlocationList(locationList, kidszone, petzone, star);
		}
		
		//카페리스트 뷰단에 보여줄 객체들만 모은 CafeListDTO에 dto에서 필요한거 담기
		List<CafeListDTO> view = new ArrayList<CafeListDTO>();
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			//cafe Table의 cafe_no를 참조해서 cafe_Image 테이블의 첫번째 이미지 가져오기
			UploadDTO cafeListDTO = mapper.findCafeImage(list.get(i).getCafe_no()).get(0);

			//카페리스트 뷰단에 보여줄 객체들만 모은 CafeListDTO에 dto에서 필요한거 담기
			CafeDTO cafeDTO = list.get(i); 
			view.add(new CafeListDTO(cafeDTO.getCafe_no(),
			cafeDTO.getCafe_name(), cafeListDTO.getImgName(), cafeDTO.getAvg_star(),
			cafeDTO.getLocation2(), cafeDTO.getKidszone(), cafeDTO.getPetzone(),
			cafeDTO.getUse_time(), cafeDTO.getSelect_count(),
			cafeListDTO.getImgLocation()));
			
		}
		model.addAttribute("list", view);
	}

	// 전체 카페 리스트 보여주기 기능
	@Override
	public void cafeAllList(Model model, int num) {
		int pageLetter = 5; // 한 페이지당 글 개수
		int allCount = mapper.selectcafeCount(); // 전체 글수

		int repeat = allCount / pageLetter;
		if (allCount % pageLetter != 0) {
			repeat += 1;
		}

		int end = num * pageLetter;
		int start = end + 1 - pageLetter;
		//cafe Table 정보 전체 가져오기
		List<CafeDTO> dto = mapper.cafeAllList(start, end);
		
		//카페리스트 뷰단에 보여줄 객체들만 모은 CafeListDTO에 dto에서 필요한거 담기
		List<CafeListDTO> view = new ArrayList<CafeListDTO>();
		System.out.println(dto.size());
		for (int i = 0; i < dto.size(); i++) {
			//cafe Table의 cafe_no를 참조해서 cafe_Image 테이블의 첫번째 이미지 가져오기
			UploadDTO cafeListDTO = mapper.findCafeImage(dto.get(i).getCafe_no()).get(0);
			
			//카페리스트 뷰단에 보여줄 객체들만 모은 CafeListDTO에 dto에서 필요한거 담기
			CafeDTO cafeDTO = dto.get(i); view.add(new CafeListDTO(cafeDTO.getCafe_no(),
			cafeDTO.getCafe_name(), cafeListDTO.getImgName(), cafeDTO.getAvg_star(),
			cafeDTO.getLocation2(), cafeDTO.getKidszone(), cafeDTO.getPetzone(),
			cafeDTO.getUse_time(), cafeDTO.getSelect_count(),
			cafeListDTO.getImgLocation()));
			
		}
		model.addAttribute("repeat", repeat);
		model.addAttribute("list", view);
	}

	// 이벤트 db 불러오기 기능
	@Override
	public void eventView(Model model) {
		// 이벤트 테이블에서 cafe_no 가져오기
		int arr[] = null;
		arr = mapper.eventCafe(); //현재 db 입력값 1,2,3,4
		
		//cafe_no 참고해서 cafe_image 불러오기
		System.out.println("arr.length : "+arr.length);
		EventViewDTO ev1 = new EventViewDTO();
		EventViewDTO ev2 = new EventViewDTO();
		EventViewDTO ev3 = new EventViewDTO();
		EventViewDTO ev4 = new EventViewDTO();
		ev1 = mapper.eventView1(); //event_no = 1인 이벤트뷰 DB불러오기
		UploadDTO img1 = mapper.findCafeImage(arr[0]).get(0);
		ev1 = mapper.eventView1(); //event_no = 2인 이벤트뷰 DB불러오기
		UploadDTO img2 = mapper.findCafeImage(arr[1]).get(0);
		ev1 = mapper.eventView1(); //event_no = 3인 이벤트뷰 DB불러오기
		UploadDTO img3 = mapper.findCafeImage(arr[2]).get(0);
		ev1 = mapper.eventView1(); //event_no = 4인 이벤트뷰 DB불러오기
		UploadDTO img4 = mapper.findCafeImage(arr[3]).get(0);
		System.out.println(img1);
		System.out.println(img2);
		System.out.println(img3);
		System.out.println(img4);
		
		// 이벤트뷰 테이블에서 데이터 가져오기 (이벤트 데이터는 총 4개 가져올거야)
		model.addAttribute("ev1", mapper.eventView1());
		model.addAttribute("ev1_img", img1);
		model.addAttribute("ev2", mapper.eventView2());
		model.addAttribute("ev2_img", img2);
		model.addAttribute("ev3", mapper.eventView3());
		model.addAttribute("ev3_img", img3);
		model.addAttribute("ev4", mapper.eventView4());
		model.addAttribute("ev4_img", img4);
//		model.addAttribute("eventImg",mapper.eventImageView());
	}

	// 카페 정보 불러오기
	@Override
	public CafeDTO cafeInfo(int cafe_no) {
		// TODO Auto-generated method stub
		return mapper.cafeInfo(cafe_no);
	}

	@Override
	@Transactional
	public boolean cafeWrite(CafeDTO dto, String imgContent, List<MultipartFile> multiFiles) {
		int resultSave = mapper.cafeWrite(dto);
		try {
			Integer cafe_no = mapper.selectNo(dto);
			fileService.cafeImgSave(cafe_no, imgContent, multiFiles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (resultSave < 1) {
			return false;
		}
		return true;
	}

	

	@Override
	public int cafeSelect(HttpServletRequest request) {

		int cafe_no = Integer.parseInt(request.getParameter("cafe_no"));
		String id = request.getParameter("id");

		int check = mapper.selectCheck(cafe_no, id); // 1:데이터o, 0:데이터x

		return check;
	}

	@Override
	public void selectMinus(HttpServletRequest request) { // 데이터 삭제

		int cafe_no = Integer.parseInt(request.getParameter("cafe_no"));
		String id = request.getParameter("id");

		mapper.selectMinus(cafe_no, id);
	}

	@Override
	public void selectPlus(HttpServletRequest request) {// 데이터 추가

		int cafe_no = Integer.parseInt(request.getParameter("cafe_no"));
		String id = request.getParameter("id");

		mapper.selectPlus(cafe_no, id);
	}

	@Override
	public void selectCountMinus(HttpServletRequest request) {

		int cafe_no = Integer.parseInt(request.getParameter("cafe_no"));

		mapper.selectCountMinus(cafe_no);
	}

	@Override
	public void selectCountPlus(HttpServletRequest request) {

		int cafe_no = Integer.parseInt(request.getParameter("cafe_no"));

		mapper.selectCountPlus(cafe_no);
	}
	
	@Override
	public void getSelectList(Model model, String id) {
		List<CafeDTO> dto = mapper.getSelectList(id);
		List<CafeListDTO> view = new ArrayList<CafeListDTO>();
		System.out.println(dto.size());
		for (int i = 0; i < dto.size(); i++) {
			//cafe Table의 cafe_no를 참조해서 cafe_Image 테이블의 첫번째 이미지 가져오기
			UploadDTO cafeListDTO = mapper.findCafeImage(dto.get(i).getCafe_no()).get(0);

			//카페리스트 뷰단에 보여줄 객체들만 모은 CafeListDTO에 dto에서 필요한거 담기
			CafeDTO cafeDTO = dto.get(i); 
			view.add(new CafeListDTO(cafeDTO.getCafe_no(),
			cafeDTO.getCafe_name(), cafeListDTO.getImgName(), cafeDTO.getAvg_star(),
			cafeDTO.getLocation2(), cafeDTO.getKidszone(), cafeDTO.getPetzone(),
			cafeDTO.getUse_time(), cafeDTO.getSelect_count(),
			cafeListDTO.getImgLocation()));
		}
		model.addAttribute("list", view);
	}

}
