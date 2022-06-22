package com.web.root.cafe.dto;
/*카페정보 

카페번호/이름/위치1(지역)/위치2(지역세부)/전화번호/이미지파일명/키즈(제한시설)/애완동물(제한시설)/이용시간/평균별점

create table cafe(
cafe_no number(30) primary key,
cafe_name varchar2(100) not null, 
location1 number(20) not null, --서울시 25개 구(0-전체/1-강남구,2-강동구~25까지) 
location2 varchar2(100) not null, --상세주소
cafe_tel varchar2(20), 
menu varchar2(1000), --메뉴
kidszone number(10), --0: 정보없음/ 1 : 키즈존(전문) /2: 노키즈존 / 3:캐어키즈존 
petzone number(10), --0:정보없음/ 1: 펫존(애견카페o) / 2:노펫존 / 3:펫허용(애견카페x)
use_time varchar2(30), --오전 ~~:~~ ~ 오후 ~~:~~ 까지 포맷으로
avg_star number(10,2), --평균 별점
logtime date default sysdate --등록일
);
*/

import java.util.List;

import com.web.root.cafe.upload.dto.UploadDTO;

public class CafeDTO {
	private int cafe_no;
	private String cafe_name;
	private int location1;
	private String location2;
	private String cafe_tel;
	private String menu;
	private int kidszone;
	private int petzone;
	private String use_time;
	private double avg_star;
	private String logtime;
	private int select_count;
	private List<UploadDTO> cafeImageDTO;

	@Override
	public String toString() {
		return "CafeDTO [cafe_no=" + cafe_no + ", cafe_name=" + cafe_name + ", location1=" + location1 + ", location2="
				+ location2 + ", cafe_tel=" + cafe_tel + ", menu=" + menu + ", kidszone=" + kidszone + ", petzone="
				+ petzone + ", use_time=" + use_time + ", avg_star=" + avg_star + ", logtime=" + logtime
				+ ", select_count=" + select_count + ", cafeImageDTO=" + cafeImageDTO + "]";
	}

	public List<UploadDTO> getCafeImageDTO() {
		return cafeImageDTO;
	}

	public void setCafeImageDTO(List<UploadDTO> cafeImageDTO) {
		this.cafeImageDTO = cafeImageDTO;
	}

	public CafeDTO() {
	}

	public int getSelect_count() {
		return select_count;
	}

	public void setSelect_count(int select_count) {
		this.select_count = select_count;
	}

	public int getCafe_no() {
		return cafe_no;
	}

	public void setCafe_no(int cafe_no) {
		this.cafe_no = cafe_no;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
	}

	public int getLocation1() {
		return location1;
	}

	public void setLocation1(int location1) {
		this.location1 = location1;
	}

	public String getLocation2() {
		return location2;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public String getCafe_tel() {
		return cafe_tel;
	}

	public void setCafe_tel(String cafe_tel) {
		this.cafe_tel = cafe_tel;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
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

	public double getAvg_star() {
		return avg_star;
	}

	public void setAvg_star(double avg_star) {
		this.avg_star = avg_star;
	}

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

}
