package com.web.root.mybatis.img;

import java.util.List;

import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.review.dto.ReviewImageDTO;

public interface ReviewImageMapper {

	public List<UploadDTO> findCafeImgByCafeNo(int cafe_no);

	public ReviewImageDTO findReviewImageByCafeNoAndId(int cafe_no, String id);

	public List<ReviewImageDTO> findReviewImageByCafeNoAndReviewNoAndId(int cafe_no, int review_no, String id);

	public int saveReviewImage(int cafe_no, int review_no, String id, String imageFileName, String imageLocation);

	public void deleteReviewImage(String id, int cafe_no, int review_no);
}
