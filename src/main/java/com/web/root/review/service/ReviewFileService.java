package com.web.root.review.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.img.ImageMapper;
import com.web.root.review.dto.ReviewImageDTO;

@Service
public class ReviewFileService {

	@Autowired
	private ImageMapper imageMapper;

	private static String DEFAULT_PATH = "/review" + File.separator;

	/* 이미지 저장 경로 및 저장 정책 결정 필요 */

	public void reviewImgSave(int cafe_no, String id, List<MultipartFile> file) {
		String path = DEFAULT_PATH + cafe_no + File.separator + id;
		
//		if (file.isDirectory()) {
//			file.mkdir();
//		}
		
	}

	public List<ReviewImageDTO> memberReviewImage(int cafe_no, int member_no) {
		ReviewImageDTO reviewImageDTO = imageMapper.findReviewImageByCafeNoAndMemberNo(cafe_no, member_no);
		String path = DEFAULT_PATH + cafe_no + File.separator + member_no;

		return null;
	}

	public UploadDTO cafeReviewImage(int cafe_no) {
		imageMapper.findCafeImageByCafeNo(cafe_no);
		return null;
	}
}
