package com.web.root.mybatis.member;

import com.web.root.member.dto.MemberDTO;

public interface MemberMapper {
	
	public MemberDTO user_check(String id); // 로그인 확인 
	public int register(MemberDTO member); //회원가입 
	public MemberDTO id_check(String id);
	public int getCode(MemberDTO dto);
}
