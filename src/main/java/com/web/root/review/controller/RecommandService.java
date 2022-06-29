package com.web.root.review.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.cafe.dto.CafeDTO;
import com.web.root.cafe.dto.RecommandDTO;
import com.web.root.cafe.service.CafeService;
import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.cafe.CafeMapper;
import com.web.root.mybatis.review.ReviewMapper;
import com.web.root.review.service.ReviewService;

@Service
public class RecommandService {

	@Autowired
	private CafeMapper cafeMapper;

	@Autowired
	private ReviewMapper reviewMapper;

	public List<RecommandDTO> recommandCafe() {

		List<CafeDTO> list = cafeMapper.recommandCafe();
		List<RecommandDTO> recommand = new ArrayList<RecommandDTO>();

		for (int i = 0; i <6; i++) {
			int cafe_no = list.get(i).getCafe_no();
			List<UploadDTO> uploadDTOs = cafeMapper.findCafeImage(cafe_no);

			UploadDTO uploadDTO = uploadDTOs.get(0);

			recommand.add(new RecommandDTO(cafe_no, list.get(i).getCafe_name(), uploadDTO.getImgName(),
					list.get(i).getAvg_star(), list.get(i).getLocation2(), list.get(i).getKidszone(),
					list.get(i).getPetzone(), list.get(i).getUse_time(), uploadDTO.getImgLocation(),
					list.get(i).getSelect_count()));

		}

		return recommand;
	}
}
