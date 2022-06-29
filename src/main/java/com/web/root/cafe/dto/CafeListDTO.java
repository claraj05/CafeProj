package com.web.root.cafe.dto;

public class CafeListDTO {
	private int cafe_no;
	private String cafe_name;
	private String imgName;
	private double avg_star;
	private String location2;
	private int kidszone;
	private int petzone;
	private String use_time;
	private int select_count;
	private String imgLocation;

	public CafeListDTO() {
	}

	public CafeListDTO(int cafe_no, String cafe_name, String imgName, double avg_star, String location2, int kidszone,
			int petzone, String use_time, int select_count, String imgLocation) {
		super();
		this.cafe_no = cafe_no;
		this.cafe_name = cafe_name;
		this.imgName = imgName;
		this.avg_star = avg_star;
		this.location2 = location2;
		this.kidszone = kidszone;
		this.petzone = petzone;
		this.use_time = use_time;
		this.select_count = select_count;
		this.imgLocation = imgLocation;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public int getCafe_no() {
		return cafe_no;
	}

	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}

	public double getAvg_star() {
		return avg_star;
	}

	public void setAvg_star(double avg_star) {
		this.avg_star = avg_star;
	}

	public String getLocation2() {
		return location2;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public int getKidszone() {
		return kidszone;
	}

	public void setKidszone(int kidszone) {
		this.kidszone = kidszone;
	}

	public int getPetzone() {
		return petzone;
	}

	public void setPetzone(int petzone) {
		this.petzone = petzone;
	}

	public String getUse_time() {
		return use_time;
	}

	public void setUse_time(String use_time) {
		this.use_time = use_time;
	}

	public int getSelect_count() {
		return select_count;
	}

	public void setSelect_count(int select_count) {
		this.select_count = select_count;
	}

}
