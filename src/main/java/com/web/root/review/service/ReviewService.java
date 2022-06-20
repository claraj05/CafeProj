package com.web.root.review.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.dto.ReviewDTO;
import com.web.root.review.dto.ReviewImageDTO;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Autowired
	private ReviewFileService reviewFileService;

	public CafeDTO cafeInfo(int cafe_no) {
		return reviewMapper.cafeInfo(cafe_no);
	}

	public List<ReviewDTO> reviewDetails(int cafe_no) {

		List<ReviewDTO> reviewDTOs = reviewMapper.findReviewsByCafeNo(cafe_no);

		for (int i = 0; i < reviewDTOs.size(); i++) {
			int review_no = reviewDTOs.get(i).getReview_no();
			String id = reviewDTOs.get(i).getId();
			List<ReviewImageDTO> reviewImages = reviewFileService.findReviewImageByCafeNoAndReviewNoAndId(cafe_no,
					review_no, id);
			reviewDTOs.get(i).setReviewImageDTOs(reviewImages);
		}

		return reviewDTOs;
	}

	@Transactional
	public boolean reviewWrite(String cafe_no, String id, String content, String grade, List<MultipartFile> file) {
		int resultSave = reviewMapper.reivewWrite(Integer.valueOf(cafe_no), id, content, Integer.valueOf(grade));
		try {
			int review_no = reviewMapper.findReviewNo(Integer.valueOf(cafe_no), id, content);
			reviewFileService.reviewImgSave(Integer.valueOf(cafe_no), review_no, id, file);
		} catch (NumberFormatException | IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (resultSave < 1)
			return false;

		return true;
	}

	public List<UploadDTO> cafeImages(int cafe_no) {

		return reviewFileService.cafeReviewImage(cafe_no);
	}

	@Transactional
	public void deleteReview(int cafe_no, int review_no, String id) {
		reviewMapper.deleteReviewById(id, review_no, cafe_no);
		reviewFileService.deleteReviewImage(id, cafe_no, review_no);
	}

	@Transactional
	public void updateReview(String id, int cafe_no, int review_no, String content, int grade,
			List<MultipartFile> files) {
		
		reviewMapper.updateReivew(id, review_no, cafe_no, grade, content);
		reviewFileService.deleteReviewImage(id, cafe_no, review_no);
		try {
			reviewFileService.reviewImgSave(cafe_no, review_no, id, files);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
