package com.web.root;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.root.cafe.service.CafeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	CafeService cf;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "index";
	}
	
	@GetMapping("index")
	public String index() {
		System.out.println("index controller 실행");
		return "index";
	}
	
	
	@RequestMapping("/searchEng")
	public String searchEng(HttpServletRequest request, Model model,HttpServletResponse response
			) throws IOException {
		String searchKW = request.getParameter("searchKW");
		System.out.println("실행");
		System.out.println("searchKW : "+searchKW);
		try {
			if(searchKW!="") {
				cf.searchEng(searchKW, model);
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
