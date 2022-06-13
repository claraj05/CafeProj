package com.web.root.review.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.maven.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.root.cafe.service.CafeService;
import com.web.root.review.dto.ReviewDTO;
import com.web.root.review.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	

//	@RequestMapping(value = "/target", method = RequestMethod.GET)
//	public String reviewPage() {
//
//		return "cafe/review";
//
//	}

	@RequestMapping(value = "/review/store", method = RequestMethod.GET)
	public ModelAndView targetReviewDetails(@RequestParam(name = "") String no) {

		Map<String, Object> map = new HashMap<String, Object>();
		ReviewDTO dto = reviewService.targetReviewDetail(no);
		map.put("cafeDetail", dto);
		map.put("reviewDetail", dto);

		return new ModelAndView("review", map, HttpStatus.OK);
	}
	
	

}
