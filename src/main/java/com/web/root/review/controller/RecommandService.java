package com.web.root.review.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.mybatis.cafe.CafeMapper;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.service.ReviewService;

@Service
public class RecommandService {

	@Autowired
	private CafeMapper cafeMapper;

	@Autowired
	private ReviewMapper reviewMapper;

	public List<CafeDTO> recommandCafe() {

		List<CafeDTO> list = cafeMapper.recommandCafe();
		List<CafeDTO> recommand = new ArrayList<CafeDTO>();

		for (int i = 0; i < list.size(); i++) {
			int cafe_no = list.get(i).getCafe_no();
			int reviewCount = reviewMapper.countReview(cafe_no);
			if (reviewCount > 1)
				recommand.add(list.get(i));
		}
		if (list.size() != 6) {
			int offset = 6 - list.size();

			for (int i = 0; i < offset; i++) {
				
			}
		}

		return recommand;
	}
}
