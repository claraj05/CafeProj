package com.web.root.mybatis.review;

import java.util.List;

import com.web.root.review.dto.ReviewDTO;

public interface ReviewMapper {

	public List<ReviewDTO> reviewLists();
}
