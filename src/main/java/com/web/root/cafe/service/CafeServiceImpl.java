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
	public void cafeAllList(Model model) {
		model.addAttribute("list", mapper.cafeAllList());
		System.out.println(mapper.cafeAllList());
	}

	@Override
	public String writeSave(HttpServletRequest request, CafeDTO dto, List<MultipartFile> multiFileList,
							String fileContent) {


		/* System.out.println(mul); */
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
			url = "/cafe/cafemanager";
		} else {
			msg = "문제가 발생했습니다..";
			url = "/cafe/cafemanager";
		}

		return bfs.getMessage(request, msg, url);

	}

}
