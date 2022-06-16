package com.web.root.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.mybatis.cafe.CafeMapper;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.dto.CafeImageDTO;
import com.web.root.review.dto.ReviewDTO;
import com.web.root.review.dto.ReviewImageDTO;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Autowired
	private ReviewFileService reviewFileService;

	/**
	 * @param target name
	 * 
	 * @return target info
	 */

	public List<ReviewDTO> targetReviewDetail(int cafe_no) {

		List<ReviewDTO> reviewDTOs = reviewMapper.targetReviewLists(cafe_no);
		
		for (int i = 0; i < reviewDTOs.size(); i++) {
			reviewDTOs.get(i)
					.setReviewImageDTOs(reviewMapper.findReviewImageByCafeNoAndId(cafe_no, reviewDTOs.get(i).getId()));
		}

		return reviewDTOs;
	}


	@Transactional
	public boolean reviewWrite(String cafe_no, String id, String content, int grade, List<MultipartFile> file) {
		int result = reviewMapper.reivewWrite(Integer.valueOf(cafe_no), id, content, grade);
		reviewFileService.reviewImgSave(Integer.valueOf(cafe_no), id, file);

		if (result < 1)
			return false;

		return true;
	}

}
