package com.web.root.review.dto;

import java.util.List;

import com.web.root.cafe.dto.CafeDTO;

public class CafeImageDTO {

	private String imgName;
	private String imgLocation;
	private int cafe_no;

	public CafeImageDTO() {
		// TODO Auto-generated constructor stub
	}

	public CafeImageDTO(String imgName, String imgLocation, int cafe_no) {
		super();
		this.imgName = imgName;
		this.imgLocation = imgLocation;
		this.cafe_no = cafe_no;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public int getCafe_no() {
		return cafe_no;
	}

	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}

}
