package com.web.root.review.controller;

import org.springframework.web.multipart.MultipartFile;

public class RequestReviewDTO {

	private String cafeNo;
	private String content;
	private MultipartFile[] files;

	public RequestReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public RequestReviewDTO(String cafeNo, String content, MultipartFile[] files) {
		super();
		this.cafeNo = cafeNo;
		this.content = content;
		this.files = files;
	}

	public String getCafeNo() {
		return cafeNo;
	}

	public void setCafeNo(String cafeNo) {
		this.cafeNo = cafeNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

}
