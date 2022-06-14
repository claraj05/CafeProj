package com.web.root.review.controller.dto;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.review.dto.ReviewDTO;

public class ResponseReviewDTO {

	private CafeDTO cafeDTO;
	
	private ReviewDTO dto;
	
	public ResponseReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public ResponseReviewDTO(CafeDTO cafeDTO, ReviewDTO dto) {
		super();
		this.cafeDTO = cafeDTO;
		this.dto = dto;
	}

	public CafeDTO getCafeDTO() {
		return cafeDTO;
	}

	public void setCafeDTO(CafeDTO cafeDTO) {
		this.cafeDTO = cafeDTO;
	}

	public ReviewDTO getDto() {
		return dto;
	}

	public void setDto(ReviewDTO dto) {
		this.dto = dto;
	}
	
	
}
