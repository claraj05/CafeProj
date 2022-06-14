package com.web.root.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.mybatis.cafe.CafeMapper;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.dto.CafeReviewDTO;
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

	public List<ReviewDTO> targetReviewDetail(int target) {

		
		return reviewMapper.targetReviewLists(target);
	}
	
	public CafeReviewDTO ormTest(int target) {

		return reviewMapper.ormTest(target);
	}


}
