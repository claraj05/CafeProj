package com.web.root.review.dto;

import java.util.List;

import com.web.root.cafe.dto.CafeDTO;

public class CafeReviewDTO {

	private CafeDTO cafeInfo;

	private List<ReviewDTO> reviews;

	public CafeReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CafeReviewDTO [cafeInfo=" + cafeInfo + ", reviews=" + reviews + "]";
	}

	public CafeReviewDTO(CafeDTO cafeInfo, List<ReviewDTO> reviews) {
		super();
		this.cafeInfo = cafeInfo;
		this.reviews = reviews;
	}

	public CafeDTO getCafeInfo() {
		return cafeInfo;
	}

	public void setCafeInfo(CafeDTO cafeInfo) {
		this.cafeInfo = cafeInfo;
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

}
