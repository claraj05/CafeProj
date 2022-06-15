package com.web.root.review.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.maven.model.Model;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.mybatis.cafe.CafeMapper;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.dto.CafeReviewDTO;
import com.web.root.review.dto.ReviewDTO;
import com.web.root.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	@Autowired
	private CafeService cafeService;

	@Autowired
	private ReviewService reviewService;

	@RequestMapping(value = "/writePage", method = RequestMethod.GET)
	public String reviewPage(Model model) {

		//model
		return "cafe/writeReview";

	}

	@RequestMapping(value = "/cafe", method = RequestMethod.GET)
	public ModelAndView targetReviewDetails(@RequestParam(name = "no") String no) {
		Map<String, Object> map = new HashMap<String, Object>();

		CafeDTO cafeInfo = cafeService.cafeInfo(Integer.valueOf(no));
		List<ReviewDTO> review = reviewService.targetReviewDetail(Integer.valueOf(no));
		map.put("cafeDetail", cafeInfo);
		map.put("reviewDetail", review);
		map.put("imgLink", review);

		return new ModelAndView("cafe/review", map, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cafe1", method = RequestMethod.GET)
	public ModelAndView targetReviewDetails1() {
		Map<String, Object> map = new HashMap<String, Object>();

		CafeDTO cafeInfo = new CafeDTO();
		List<ReviewDTO> review = new ArrayList<ReviewDTO>();
		cafeInfo.setCafe_name("hi");
		cafeInfo.setAvg_star(4.0);
		cafeInfo.setCafe_tel("010-0000-1111");
		cafeInfo.setKidszone(1);
		cafeInfo.setLogtime("9:00 ~ 18:00");
		cafeInfo.setMenu("hi");
		
		List<String> s = new ArrayList<String>();
		s.add("hi1");
		s.add("hi2");
		s.add("hi3");
		s.add("hi4");
		s.add("hi5");
		
		List<ReviewDTO> reviewDTOs = new ArrayList<ReviewDTO>();
		reviewDTOs.add(new ReviewDTO(1, 1,"reviewContent", "id", "review_savedate", "image", 4));
		
		map.put("cafeDetail", cafeInfo);
		map.put("reviewDetail", review);
		map.put("cafeImage", s);

		return new ModelAndView("cafe/review", map, HttpStatus.OK);
	}
	/*
	 * @RequestMapping(value = "/write", method = RequestMethod.POST, consumes =
	 * MediaType.MULTIPART_FORM_DATA_VALUE) public void writeReview(@ModelAttribute
	 * RequestReviewDTO reviewDTO, HttpServletRequest httpServletRequest) { String
	 * cafeNo = httpServletRequest.getParameter("cafeNo");
	 * System.out.println(cafeNo);
	 * logger.info("date => content : {} cafe_no : {}, files : {}",
	 * reviewDTO.getCafeNo(), reviewDTO.getContent()); //
	 * reviewService.reviewWrite(cafe_no, content, multipartFile);
	 * 
	 * }
	 */

	@RequestMapping(value = "/writeRequest", method = RequestMethod.POST)
	public void writeReview(MultipartHttpServletRequest httpServletRequest) {
		String cafeNo = httpServletRequest.getParameter("cafeNo");
		String content = httpServletRequest.getParameter("content");
		MultiValueMap<String, MultipartFile> files = httpServletRequest.getMultiFileMap();
		System.out.println(files.get("files"));
		logger.info("date => content : {} cafe_no : {}, files : {}", content, cafeNo);
		// reviewService.reviewWrite(cafe_no, content, multipartFile);

	}

	@Autowired
	private ReviewMapper mapper;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		System.out.println(mapper.targetReviewLists(1));
	}

	/*
	 * @RequestMapping(value = "/ormTest", method = RequestMethod.GET) public void
	 * ormTest(@RequestParam(name = "no") String no) { Map<String, Object> map = new
	 * HashMap<String, Object>();
	 * 
	 * CafeReviewDTO dto = reviewService.ormTest(Integer.valueOf(no));
	 * 
	 * }
	 */
}
