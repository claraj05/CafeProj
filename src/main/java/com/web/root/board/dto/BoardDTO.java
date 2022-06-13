package com.web.root.board.dto;
/*
 게시판 테이블

게시번호/제목/내용/작성자/작성일/조회수/첨부파일
create table board(
Write_no number(10) primary key,
Title varchar2(100) not null,
Content varchar2(300) not null,
Savedate date default sysdate,
Hit number(10) default 0,
ImageFileName varchar2(100),
like_count number(100),
id varchar2(20) not null,
constraint fk_test foreign key(id) references member(id) on delete cascade
);
create sequence board_seq nocache nocycle; */
public class BoardDTO {
	private int write_no;
	private String title;
	private String content;
	private String savedate;
	private int hit;
	private String imageFileName;
	private int like_count;
	private String id;
	
	public BoardDTO() {}

	public BoardDTO(int write_no, String title, String content, String savedate, int hit, String imageFileName,
			int like_count, String id) {
		this.write_no = write_no;
		this.title = title;
		this.content = content;
		this.savedate = savedate;
		this.hit = hit;
		this.imageFileName = imageFileName;
		this.like_count = like_count;
		this.id = id;
	}

	public int getWrite_no() {
		return write_no;
	}

	public void setWrite_no(int write_no) {
		this.write_no = write_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSavedate() {
		return savedate;
	}

	public void setSavedate(String savedate) {
		this.savedate = savedate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getLike_count() {
		return like_count;
	}

	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
