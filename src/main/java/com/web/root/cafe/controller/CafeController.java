package com.web.root.cafe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.session.name.MemberSession;

@Controller
@RequestMapping("cafe")
public class CafeController implements MemberSession {

	private static final Logger logger2 = LoggerFactory.getLogger(CafeController.class);
	@Autowired
	CafeService cf;

	@GetMapping("searchView")
	public String searchView() {
		return "cafe/searchView";
	}

	@RequestMapping("review")
	public String review(HttpServletRequest request) {
		return "cafe/review";
	}

	@GetMapping("eventView")
	public String eventView(HttpServletRequest request, Model model) {
		cf.eventView(model);
		return "cafe/eventView";
	}


	@GetMapping("searchResult")
	public String searchResult(HttpServletRequest request, @RequestParam("location1") String location1,
			@RequestParam("kidszone") String kidszone, @RequestParam("petzone") String petzone,
			@RequestParam("star") String star, Model model) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String[] locationList = request.getParameterValues("location1");
		kidszone = request.getParameter("kidszone");
		petzone = request.getParameter("petzone");
		star = request.getParameter("star");
		if (locationList[0].contentEquals("0")) {
			String test[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
					"17", "18", "19", "20", "21", "22", "23", "24", "25" };
			cf.getlocationList(request, test, kidszone, petzone, star, model);
		} else {
			cf.getlocationList(request, locationList, kidszone, petzone, star, model);
		}
		model.addAttribute("location1", location1);
		model.addAttribute("kidszone", kidszone);
		model.addAttribute("petzone", petzone);
		model.addAttribute("star", star);
		return "cafe/searchResult";
	}

	@GetMapping("cafeAllList")
	public String test(HttpServletRequest request, Model model, HttpServletResponse response,
			@RequestParam(value = "num", required = false, defaultValue = "1") int num) throws Exception {
		cf.cafeAllList(model, num);
		return "cafe/cafeAllList";
	}


	@GetMapping("cafemanager")
	public String cafemanager() {
		return "cafe/cafemanager";
	}
	
	@RequestMapping(value = "/writeSave", method = RequestMethod.POST)
	public String writeSave(CafeDTO dto, @RequestParam("imgContent") String imgContent,
			HttpServletRequest request, Model model,MultipartHttpServletRequest httpServletRequest) throws IOException {
		
		List<MultipartFile> multiFiles = httpServletRequest.getMultiFileMap().get("multiFiles");
		cf.cafeWrite(dto, imgContent, multiFiles);

		return "redirect:/cafe/cafeAllList";

	}


	@GetMapping("cafeSelect")
	public String cafeSelect(HttpServletRequest request, RedirectAttributes ra) {

		int check = cf.cafeSelect(request); // 1:데이터o, 0:데이터x

		if (check == 1) {// 데이터o->데이터 삭제(좋아요 체크 해제)
			cf.selectMinus(request);
			cf.selectCountMinus(request);
			check = 0;
		} else {// 데이터x->데이터 추가(좋아요 체크)
			cf.selectPlus(request);
			cf.selectCountPlus(request);
			check = 1;
		}
		ra.addAttribute("cafe_no", request.getParameter("cafe_no"));
		ra.addAttribute("location1", request.getParameter("location1"));
		ra.addAttribute("kidszone", request.getParameter("kidszone"));
		ra.addAttribute("petzone", request.getParameter("petzone"));
		ra.addAttribute("star", request.getParameter("star"));
		ra.addAttribute("check", check);
		if (request.getHeader("Referer") != null) {
		    return "redirect:" + request.getHeader("Referer");
		  } else {
		    return "cafe/searchView";
		  }
	}
	
	@GetMapping("mycafe")
	public String mycafe(Model model, @RequestParam("id") String id) {
		
		System.out.println(id);
		cf.getSelectList(model, id);
		
		return "cafe/mycafe";
	}
	
	@GetMapping("cafeSelect2")
	   public String cafeSelect2(HttpServletRequest request, RedirectAttributes ra) {
	      
	      int check=cf.cafeSelect(request); //1:데이터o, 0:데이터x
	      if(check==1) {//데이터o->데이터 삭제(좋아요 체크 해제)
	         cf.selectMinus(request);
	         cf.selectCountMinus(request);
	         check=0;
	      }else {//데이터x->데이터 추가(좋아요 체크)
	         cf.selectPlus(request);
	         cf.selectCountPlus(request);
	         check=1;
	      }
	      
	      String id=request.getParameter("id");
	      ra.addAttribute("id", id);
	      
	      return "redirect:mycafe";
	   }
	
}
