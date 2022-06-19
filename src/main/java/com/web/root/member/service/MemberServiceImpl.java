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
	public int user_check(HttpServletRequest request, Model model) {
		MemberDTO dto = mapper.user_check(request.getParameter("id"));
		if(dto != null) {
			if(request.getParameter("pw").equals(dto.getPw())) {
				int code = mapper.getCode(dto);
				System.out.println("code"+code);
				model.addAttribute("code",code);
				return 0;
			}
		}
		return 1;
	}

	

	@Override
	public int getCode(HttpServletRequest request,Model model) {
		MemberDTO dto = mapper.user_check(request.getParameter("id"));
		int code = mapper.getCode(dto);
		model.addAttribute("code", code);
		return 0;
	}


	@Override
	public int id_check(HttpServletRequest request) {
			MemberDTO dto = mapper.id_check(request.getParameter("id"));
			if(dto != null) {
				if(request.getParameter("id").equals(dto.getId())) {
					return 0;
				}
			}
		return 1;
	}


	
}












