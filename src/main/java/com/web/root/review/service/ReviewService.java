package com.web.root.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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

	@Transactional
	public boolean reviewWrite(String cafe_no, String content, List<MultipartFile> file) {
		int result = reviewMapper.reivewWrite(Integer.valueOf(cafe_no), content);

		if (result < 1)
			return false;

		return true;
	}

	/*
	 * public CafeReviewDTO ormTest(int target) {
	 * 
	 * return reviewMapper.ormTest(target); }
	 * 
	 */
}
