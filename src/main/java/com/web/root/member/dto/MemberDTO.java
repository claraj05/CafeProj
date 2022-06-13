package com.web.root.member.dto;
/*계정코드/아이디/이름/비밀번호/생년월일/성별/이메일/전화번호
create table member(
code number(10) not null, -- 0:관리자 계정 / 1:사용자계정
id varchar2(20) primary key,
pw varchar2(20) not null,
name varchar2(20) not null, 
gender number(10) not null, --1 : 남자 / 2: 여자
addr1 varchar2(30),
addr2 varchar2(30),
phone number(10) not null, 
email varchar2(20),
domain varchar2(20),
birth varchar2(30), 
savedate date sysdate
);*/
public class MemberDTO {

	private int code;
	private String id;
	private String pw; 
	private String name;
	private int gender;
	private String addr1;
	private String addr2;
	private String phone;
	private String email;
	private String domain;
	private String birth;
	private String savedate;
	
	public MemberDTO() {}

	public MemberDTO(int code, String id, String pw, String name, int gender, String addr1, String addr2, String phone,
			String email, String domain, String birth, String savedate) {
		this.code = code;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.email = email;
		this.domain = domain;
		this.birth = birth;
		this.savedate = savedate;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSavedate() {
		return savedate;
	}

	public void setSavedate(String savedate) {
		this.savedate = savedate;
	}
	
	
}
