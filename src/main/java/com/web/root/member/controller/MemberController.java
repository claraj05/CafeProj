package com.web.root.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.root.session.name.MemberSession;

@Controller
@RequestMapping("member")
public class MemberController implements MemberSession {

	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "member/logout";
	}
	
	@GetMapping("joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	@GetMapping("myInfo")
	public String myInfo() {
		return "member/myInfo";
	}
}
