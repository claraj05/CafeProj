package com.web.root.mybatis.img;

import com.web.root.cafe.upload.dto.UploadDTO;

public interface ImageMapper {

	public UploadDTO findCafeImageByCafeNo(int cafe_no);
	
	public UploadDTO findReviewImageByCafeNoAndMemberNo(int cafe_no,int member_no);
}
