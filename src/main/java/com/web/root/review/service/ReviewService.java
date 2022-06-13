package com.web.root.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.mybatis.cafe.CafeMapper;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.dto.ReviewDTO;

@Service
public class ReviewService {

	@Autowired
	private CafeMapper cafeMapper;

	@Autowired
	private ReviewMapper reviewMapper;

	/**
	 * @param target name
	 * 
	 * @return target info
	 */

	public ReviewDTO targetReviewDetail(String target) {

		return testData();
	}

	public void targetReviews() {

	}

	private ReviewDTO testData() {

		ReviewDTO reviewDTO = new ReviewDTO(1, 1, "hi", "2", "hi", "hi", 1);

		return reviewDTO;
	}
}
