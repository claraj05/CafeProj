package com.web.root.review.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.img.ImageMapper;
import com.web.root.review.dto.ReviewImageDTO;

@Service
public class ReviewFileService {

	@Autowired
	private ImageMapper cafeImageMapper;
	
	

	private static String DEFAULT_PATH = "/";

	/* 이미지 저장 경로 및 저장 정책 결정 필요 */

	public void imgSave(int cafe_no, String fileName) {
		
	}

	public ReviewImageDTO memberReviewImage(int cafe_no, int member_no) {
		cafeImageMapper.findReviewImageByCafeNoAndMemberNo(cafe_no, member_no);
		return null;
	}

	public UploadDTO cafeReviewImage(int cafe_no) {
		cafeImageMapper.findCafeImageByCafeNo(cafe_no);
		return null;
	}
}
