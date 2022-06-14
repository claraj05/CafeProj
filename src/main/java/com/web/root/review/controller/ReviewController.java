package com.web.root.review.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Model;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private CafeService cafeService;

	@Autowired
	private ReviewService reviewService;

//	@RequestMapping(value = "/target", method = RequestMethod.GET)
//	public String reviewPage() {
//
//		return "cafe/review";
//
//	}
	
	

	@RequestMapping(value = "/cafe", method = RequestMethod.GET)
	public ModelAndView targetReviewDetails(@RequestParam(name = "no") String no) {
		Map<String, Object> map = new HashMap<String, Object>();

		CafeDTO cafeInfo = cafeService.cafeInfo(Integer.valueOf(no));
		List<ReviewDTO> review = reviewService.targetReviewDetail(Integer.valueOf(no));
		map.put("cafeDetail", cafeInfo);
		map.put("reviewDetail", review);

		return new ModelAndView("cafe/review", map, HttpStatus.OK);
	}
	
	
	

	@Autowired
	private ReviewMapper mapper;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test() {
		System.out.println(mapper.targetReviewLists(1));
	}
	
	@RequestMapping(value = "/ormTest", method = RequestMethod.GET)
	public void ormTest(@RequestParam(name = "no") String no) {
		Map<String, Object> map = new HashMap<String, Object>();

		CafeReviewDTO dto = reviewService.ormTest(Integer.valueOf(no));
		
	}
}
