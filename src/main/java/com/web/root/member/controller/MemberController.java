package com.web.root.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.web.root.member.dto.MemberDTO;
import com.web.root.member.service.MemberService;
import com.web.root.session.name.MemberSession;

@Controller
@RequestMapping("member")
public class MemberController implements MemberSession {

	@Autowired
	private MemberService ms;

	@GetMapping("login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("user_check")
	public String userCheck(HttpServletRequest request, RedirectAttributes rs) {
		int result = ms.user_check(request);
		int code = ms.getCode(request);
		if(result == 0) {
			rs.addAttribute("id", request.getParameter("id"));
			rs.addAttribute("code", code);
			return "redirect:successLogin";
		}
		return "redirect:login";
	}
	
	@RequestMapping("successLogin")
	public String successLogin(@RequestParam("id") String id, @RequestParam("code") int code, HttpSession session) {
		session.setAttribute(LOGIN, id); //session 값 저장 
		session.setAttribute(CODE, code); //session 값 저장 
		return "redirect:/index";
	}
	
	
	@RequestMapping("register")
	public String joinForm() { 
	 return "member/joinForm"; 
	}
	 
	 
	@RequestMapping("joinForm")
	public String joinform(MemberDTO member, HttpServletRequest request, 
			@RequestParam("addr1") String addr1,
			@RequestParam("addr2") String addr2,
			@RequestParam("addr3") String addr3) {
		member.setAddr(request.getParameter("addr1")+request.getParameter("addr2")+request.getParameter("addr3"));
		System.out.println(member.toString());
		int result = ms.register(member);
		if(result == 1) 
			return "redirect:/index";
		return "redirect:register_fail";
	}

	
	
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
		return "redirect:/index";
	}
	 
	
	@GetMapping("myInfo")
	public String myInfo() {
		return "member/myInfo";
	}
}
