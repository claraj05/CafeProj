package com.web.root.member.service;

import javax.servlet.http.HttpServletRequest;

import com.web.root.member.dto.MemberDTO;

public interface MemberService {

	public int user_check(HttpServletRequest request);
	
	public int register(MemberDTO member);
	
	public int id_check(HttpServletRequest request);
	
	public int getCode(HttpServletRequest request);
}
