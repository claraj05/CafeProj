package com.web.root.mybatis.review;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.review.dto.CafeReviewDTO;
import com.web.root.review.dto.ReviewDTO;

public interface ReviewMapper {

	public List<ReviewDTO> reviewLists();

	public List<ReviewDTO> targetReviewLists(int target);
	
	public CafeReviewDTO ormTest(int target);

}
