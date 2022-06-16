package com.web.root.cafe.upload.dto;

public class UploadDTO {

	private String imgName;
	private String imgLocation;
	private String imgContent;
	private int cafe_no;
	
	public UploadDTO () {}
	
	

	@Override
	public String toString() {
		return "UploadDTO [imgName=" + imgName + ", imgLocation=" + imgLocation + ", imgContent=" + imgContent
				+ ", cafe_no=" + cafe_no + "]";
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

	public String getImgContent() {
		return imgContent;
	}

	public void setImgContent(String imgContent) {
		this.imgContent = imgContent;
	}

	public int getCafe_no() {
		return cafe_no;
	}

	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}

	
	
	
}
