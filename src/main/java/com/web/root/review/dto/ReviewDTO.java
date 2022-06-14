package com.web.root.review.dto;

import java.sql.Date;

/*리뷰 테이블

카페번호/리뷰번호/제목/내용/작성자/작성일/별점

create table review (
cafe_no number(20),
constraint fk_cafe foreign key(cafe_no) references cafe(cafe_no) on delete cascade,
review_no number(50) not null,  --카페 별 번호를 매겨 총 리뷰 수 카운트 할 방법 필요 
review_content varchar2(100) not null, 
id varchar2(20), 
constraint fk_test foreign key(id) references member(id) on delete cascade
review_savedate date default sysdate,
imageFileName varchar2(100), --이미지 파일명
grade number(10) --1~5까지 매기기
);

카페 별 리뷰 평균 구하기 -> 이걸 cafe table에서 평균 별점 처리에 넣어야 할 듯
select avg(star) where no = ~ from review;

create sequence rev_seq nocache nocycle;*/
public class ReviewDTO {
	private int cafe_no;
	private int review_no;
	private String review_content;
	private String id;
	private String review_savedate;
	private String imageFileName;
	private int grade;

	public ReviewDTO() {
	}

	public ReviewDTO(int cafe_no, int review_no, String review_content, String id, String review_savedate,
			String imageFileName, int grade) {
		super();
		this.cafe_no = cafe_no;
		this.review_no = review_no;
		this.review_content = review_content;
		this.id = id;
		this.review_savedate = review_savedate;
		this.imageFileName = imageFileName;
		this.grade = grade;
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

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReview_savedate() {
		return review_savedate;
	}

	public void setReview_savedate(String review_savedate) {
		this.review_savedate = review_savedate;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
