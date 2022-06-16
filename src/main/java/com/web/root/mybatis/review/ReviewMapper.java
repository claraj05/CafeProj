package com.web.root.mybatis.review;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.review.dto.CafeReviewDTO;
import com.web.root.review.dto.ReviewDTO;

public interface ReviewMapper {

	public List<ReviewDTO> reviewLists();

	public List<ReviewDTO> targetReviewLists(int target);

	public int reivewWrite(int cafe_no, String id, String content,int grade);

	public int cafeReviewTotalCount(int target);

	/* public CafeReviewDTO ormTest(int target); */

	/* 카페 이미지 테이블 필요 */
}
