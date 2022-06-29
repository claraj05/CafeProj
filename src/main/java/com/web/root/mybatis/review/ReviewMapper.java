package com.web.root.mybatis.review;

import java.util.List;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.review.dto.ReviewDTO;

public interface ReviewMapper {

	public CafeDTO cafeInfo(int cafe_no);

	public List<UploadDTO> cafeImageDTOs();

	public List<ReviewDTO> reviewLists();

	public List<ReviewDTO> findReviewsByCafeNo(int cafe_no);

	public int reivewWrite(int cafe_no, String id, String content, int grade);

	public int cafeReviewTotalCount(int target);

	public int findReviewNo(int cafe_no, String id, String content);

	public void deleteReviewById(String id, int review_no, int cafe_no);

	public void updateReivew(String id, int review_no, int cafe_no, int grade, String review_content);

	public double findGradeByCafeNo(String cafe_no);
	
	public int countReview(int cafe_no);
	/* public CafeReviewDTO ormTest(int target); */

	/* 카페 이미지 테이블 필요 */
}
