package com.web.root.member.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
			if(dto != null) {
				if(request.getParameter("id").equals(dto.getId())) {
					return 0;
				}
			}
		return 1;
	}
}












