package com.web.root.mybatis.img;

import com.web.root.cafe.upload.dto.UploadDTO;
import com.web.root.review.dto.ReviewImageDTO;

public interface ImageMapper {

	public UploadDTO findCafeImageByCafeNo(int cafe_no);
	
	public ReviewImageDTO findReviewImageByCafeNoAndMemberNo(int cafe_no,int review_no);
}
