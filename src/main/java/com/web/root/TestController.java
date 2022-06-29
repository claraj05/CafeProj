package com.web.root;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.dto.CafeListDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.cafe.CafeMapper;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private CafeMapper mapper;
	
	@RequestMapping(value="/cafeListTest",method = RequestMethod.GET)
	public void cafeAllList(int num) {
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
		List<UploadDTO> test = new ArrayList<UploadDTO>();
		//카페리스트 뷰단에 보여줄 객체들만 모은 CafeListDTO에 dto에서 필요한거 담기
		List<CafeListDTO> view = new ArrayList<CafeListDTO>();
		System.out.println(dto.size());
		for (int i = 0; i < dto.size(); i++) {
			//cafe Table의 cafe_no를 참조해서 cafe_Image 테이블의 첫번째 이미지 가져오기
			test = mapper.findCafeImage(dto.get(i).getCafe_no());
			System.out.println(test);
			UploadDTO cafeListDTO = mapper.findCafeImage(dto.get(i).getCafe_no()).get(0);
			//카페리스트 뷰단에 보여줄 객체들만 모은 CafeListDTO에 dto에서 필요한거 담기
			CafeDTO cafeDTO = dto.get(i); view.add(new CafeListDTO(cafeDTO.getCafe_no(),
			cafeDTO.getCafe_name(), cafeListDTO.getImgName(), cafeDTO.getAvg_star(),
			cafeDTO.getLocation2(), cafeDTO.getKidszone(), cafeDTO.getPetzone(),
			cafeDTO.getUse_time(), cafeDTO.getSelect_count(),
			cafeListDTO.getImgLocation()));
			
		}
	}
	
}
