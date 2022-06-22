package com.web.root.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.web.root.member.dto.MemberDTO;

public interface MemberService {

	public int user_check(HttpServletRequest request);
	
	public int register(MemberDTO member);
	
	public int id_check(HttpServletRequest request);
	
	public int getCode(HttpServletRequest request);
	
	public void memberInfo(Model model, String id);
	
	public void info(String id, Model model);
	
	public void modify(HttpServletRequest request);
	
	public void delete(String id);
	
	public String findId(HttpServletRequest request);
	public String findPw(HttpServletRequest request);
}
