package com.web.root.review.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.mybatis.img.ReviewImageMapper;
import com.web.root.review.dto.ReviewImageDTO;

@Service
public class ReviewFileService {
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private ReviewImageMapper reviewImageMapper;

	private static String DEFAULT_PATH = "C:\\" + "reviewImg" + File.separator;

	/* 이미지 저장 경로 및 저장 정책 결정 필요 */

	public void reviewImgSave(int cafe_no, int review_no, String id, List<MultipartFile> files)
			throws IllegalStateException, IOException {
		String path = DEFAULT_PATH + cafe_no + File.separator + id;

		File file = new File(path);

		if (!file.exists()) {
			file.mkdirs();
		}
		for (int i = 0; i < files.size(); i++) {
			file = new File(path, files.get(i).getOriginalFilename());
			files.get(i).transferTo(file);
			reviewImageMapper.saveReviewImage(cafe_no, review_no, id, files.get(i).getOriginalFilename(), path);
		}

	}

	public List<ReviewImageDTO> findReviewImageByCafeNoAndReviewNoAndId(int cafe_no, int review_no, String id) {
		List<ReviewImageDTO> reviewImageDTO = reviewImageMapper.findReviewImageByCafeNoAndReviewNoAndId(cafe_no,
				review_no, id);

		return reviewImageDTO;
	}

	public List<UploadDTO> cafeReviewImage(int cafe_no) {

		return reviewImageMapper.findCafeImgByCafeNo(cafe_no);
	}

	public void deleteReviewImage(String id, int cafe_no, int review_no) {
		List<ReviewImageDTO> reviewImageDTOs = reviewImageMapper.findReviewImageByCafeNoAndReviewNoAndId(cafe_no,
				review_no, id);
		reviewImageMapper.deleteReviewImage(id, cafe_no, review_no);

		for (int i = 0; i < reviewImageDTOs.size(); i++) {
			String path = reviewImageDTOs.get(i).getImageLocation() + File.separator + reviewImageDTOs.get(i).getImageFileName();
			File file = new File(path);
			file.delete();
		}
	}
}
