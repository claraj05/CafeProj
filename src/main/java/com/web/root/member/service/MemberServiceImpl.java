package com.web.root.member.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.web.root.member.dto.MemberDTO;
import com.web.root.mybatis.member.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;
	
	
	@Override
	public int register(MemberDTO member){
		try {
			MemberDTO dto = member;
			System.out.println(dto.getAddr());
			return mapper.register(dto);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public int user_check(HttpServletRequest request) {
		MemberDTO dto = mapper.user_check(request.getParameter("id"));
		if(dto != null) {
			if(request.getParameter("pw").equals(dto.getPw())) {
				return 0;
			}
		} 
		return 1;
	}
	
	@Override
	public int getCode(HttpServletRequest request) {
		MemberDTO dto = mapper.user_check(request.getParameter("id"));

		return dto.getCode();
	}


	@Override
	public int id_check(HttpServletRequest request) {
		MemberDTO dto = mapper.id_check(request.getParameter("id"));
		//int result=-1; //오류 발생
		if(dto != null) {
				return 0;
			}
			return 1;
	}


	@Override
	public void memberInfo(Model model, String id) {
		model.addAttribute("member", mapper.getMember(id));	
	}


	@Override
	public void info(String id, Model model) {
		model.addAttribute("info", mapper.getMember(id));
	}


	@Override
	public void modify(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String addr = request.getParameter("addr");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String domain = request.getParameter("domain");
		String birth = request.getParameter("birth");
		MemberDTO dto = new MemberDTO();
		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setGender(gender);
		dto.setAddr(addr);
		dto.setEmail(email);
		dto.setPhone(phone);
		dto.setDomain(domain);
		dto.setBirth(birth);
		
		mapper.modify(dto);
		
		//저장
	}

	@Override
	public void delete(String id) {
		
		mapper.delete(id);
		
	}
	
	@Override
	public String findId(HttpServletRequest request) {
		
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		System.out.println(name);
		System.out.println(phone);
		
		return mapper.findId(name, phone);
	}


	@Override
	public String findPw(HttpServletRequest request) {
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String birth=request.getParameter("birth");
		
		return mapper.findPw(id, name, birth);
	}
}












