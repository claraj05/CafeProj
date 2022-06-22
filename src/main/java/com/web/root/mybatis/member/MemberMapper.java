package com.web.root.mybatis.member;

import java.util.ArrayList;

import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	public MemberDTO user_check(String id); // 로그인 확인 
	public int register(MemberDTO member); //회원가입 
	public MemberDTO id_check(String id);
	public ArrayList<MemberDTO> memberInfo();
	public MemberDTO getMember(String id);
	public void modify(MemberDTO dto);
	public void delete(String id);
	public String findId(String name, String phone);
	public String findPw(String id, String name, String birth);
}