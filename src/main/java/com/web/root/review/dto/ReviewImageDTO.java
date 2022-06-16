package com.web.root.review.dto;

public class ReviewImageDTO {

	private int cafe_no;
	private String memberName;
	private String imgLocation;
	private String imgName;

	public ReviewImageDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewImageDTO(int cafe_no, String memberName, String imgLocation, String imgName) {
		super();
		this.cafe_no = cafe_no;
		this.memberName = memberName;
		this.imgLocation = imgLocation;
		this.imgName = imgName;
	}

	public int getCafe_no() {
		return cafe_no;
	}

	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}
