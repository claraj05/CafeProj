package com.web.root.review.dto;

public class ReviewImageDTO {

	private int cafe_no;
	private int review_no;
	private String id;
	private String imageFileName;
	private String imageLocation;

	public ReviewImageDTO() {
		// TODO Auto-generated constructor stub
	}

	public ReviewImageDTO(int cafe_no, int review_no, String id, String imageFileName, String imageLocation) {
		super();
		this.cafe_no = cafe_no;
		this.review_no = review_no;
		this.id = id;
		this.imageFileName = imageFileName;
		this.imageLocation = imageLocation;
	}

	public int getCafe_no() {
		return cafe_no;
	}

	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}

	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

}
