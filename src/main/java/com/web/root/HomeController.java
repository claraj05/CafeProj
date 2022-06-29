package com.web.root;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.root.cafe.dto.RecommandDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.review.controller.RecommandService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private RecommandService recommandService;
	
	@Autowired
	CafeService cf;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		System.out.println("index controller 실행");		
		Map<String, Object> map = new HashMap<String, Object>();
		List<RecommandDTO> sectionOne = new ArrayList<RecommandDTO>();
		List<RecommandDTO> sectionTwo = new ArrayList<RecommandDTO>();
		List<RecommandDTO> cafes = recommandService.recommandCafe();
		

		for(int i=0;i<cafes.size();i++) {
			if(i<3) {
				sectionOne.add(cafes.get(i));
			}else {
				sectionTwo.add(cafes.get(i));
			}
		}
		System.out.println(sectionOne);
		System.out.println(sectionTwo);

		map.put("recommandSectionOne", sectionOne);
		map.put("recommandSectionTwo", sectionTwo);
		
		return new ModelAndView("index", map, HttpStatus.OK);
	}
	
//	@GetMapping("index")
//	public String index() {
//		System.out.println("index controller 실행");
//		return "index";
//	}
//	
	/*
	 * @GetMapping("index") public ModelAndView index() {
	 * System.out.println("index controller 실행"); Map<String, Object> map = new
	 * HashMap<String, Object>(); List<RecommandDTO> sectionOne = new
	 * ArrayList<RecommandDTO>(); List<RecommandDTO> sectionTwo = new
	 * ArrayList<RecommandDTO>(); List<RecommandDTO> cafes =
	 * recommandService.recommandCafe();
	 * 
	 * 
	 * for(int i=0;i<cafes.size();i++) { if(i<3) { sectionOne.add(cafes.get(i));
	 * }else { sectionTwo.add(cafes.get(i)); } } System.out.println(sectionOne);
	 * System.out.println(sectionTwo);
	 * 
	 * map.put("recommandSectionOne", sectionOne); map.put("recommandSectionTwo",
	 * sectionTwo);
	 * 
	 * return new ModelAndView("index", map, HttpStatus.OK); }
	 */
	
	@RequestMapping("/searchEng")
	public String searchEng(HttpServletRequest request, Model model,HttpServletResponse response,
			@RequestParam(value = "star", required = false, defaultValue = "0") int star,
			@RequestParam(value = "num", required = false, defaultValue = "1") int num) throws IOException {
		String searchKW = request.getParameter("searchKW");
		System.out.println("searchKW : "+searchKW);
		model.addAttribute("star", star);
		try {
			if(searchKW!="") {
				cf.searchEng(searchKW, model,num);
			}else {
				model.addAttribute("kwResult",null);
			}
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}	
		return "cafe/searchKWResult";
	}
	@RequestMapping("/searchEngS")
	public String searchEngS(HttpServletRequest request, Model model,HttpServletResponse response,
			@RequestParam(value = "num", required = false, defaultValue = "1") int num) throws IOException {
		String searchKW = request.getParameter("searchKW");
		System.out.println("searchKW : "+searchKW);
		int star = 1; 
		model.addAttribute("star", star);
		try {
			if(searchKW!="") {
				cf.searchEngS(searchKW, model,num);
			}else {
				model.addAttribute("kwResult",null);
			}
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}	
		return "cafe/searchKWResult";
	}
	
}
