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

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.review.controller.RecommandService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	CafeService cf;

	@Autowired
	private RecommandService recommandService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}

	@GetMapping("index")
	public ModelAndView index() {
		System.out.println("index controller 실행");
		Map<String, Object> map = new HashMap<String, Object>();
		List<CafeDTO> sectionOne = new ArrayList<CafeDTO>();
		List<CafeDTO> sectionTwo = new ArrayList<CafeDTO>();
		List<CafeDTO> cafes = recommandService.recommandCafe();
		

		for(int i=0;i<cafes.size();i++) {
			if(i<3) {
				sectionOne.add(cafes.get(i));
			}else {
				sectionTwo.add(cafes.get(i));
			}
		} 

		map.put("recommandSectionOne", sectionOne);
		map.put("recommandSectionTwo", sectionTwo);

		return new ModelAndView("index", map, HttpStatus.OK);
	}

	@RequestMapping("/searchEng")
	public String searchEng(HttpServletRequest request, Model model, HttpServletResponse response) throws IOException {
		String searchKW = request.getParameter("searchKW");
		System.out.println("실행");
		System.out.println("searchKW : " + searchKW);
		try {
			if (searchKW != "") {
				cf.searchEng(searchKW, model);
			} else {
				model.addAttribute("kwResult", null);
			}
		} catch (Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		return "cafe/searchKWResult";
	}

}
