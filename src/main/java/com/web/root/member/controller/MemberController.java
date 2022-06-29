package com.web.root.member.controller;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public void userCheck(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
		
		int result = ms.user_check(request);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		if(result == 0) {
			String id = request.getParameter("id");
			int code = ms.getCode(request);
			out.print("<script>location.href='" + request.getContextPath() + "/member/successLogin?id="+id+"&code="+code+"'</script>");
					
		}else if(result==1){
			System.out.println("실패");
			
			out.print("<script>alert('아이디 또는 비밀번호가 일치하지 않습니다. 다시 시도하세요');"+
			"location.href='" + request.getContextPath() + "/member/login'</script>");
			 
		}
	}

	
	@GetMapping("checkId")
	public String checkId(HttpServletRequest request, Model model) {
		int result = ms.id_check(request);
		
		String id = request.getParameter("id");
		System.out.println("id를 가져옴 : " + id);
		model.addAttribute("result", result);
		System.out.println(result);
		
		return "member/checkId";
	}
	
	
	@RequestMapping("successLogin")
	public String successLogin(@RequestParam("id") String id, @RequestParam("code") int code, HttpSession session) {
		session.setAttribute(LOGIN, id); //session 값 저장 
		session.setAttribute(CODE, code); //session 값 저장 
		return "redirect:/";
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
			return "redirect:/";
		return "redirect:register_fail";
	}

	
	
	
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginUser") != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	 
	
	
	@GetMapping("memberInfo")
	public String memberInfo(Model model, @RequestParam("id") String id) {
		ms.memberInfo(model, id);
		return "member/memberInfo";
	}
	
	@RequestMapping("info")
	public String info(@RequestParam("id") String id, Model model) {
		ms.info(id, model);
		return "member/info";
	}
	
	@PostMapping("modifyForm")
	public String modifyForm(HttpServletRequest request, RedirectAttributes ra) {
		
		ms.modify(request);
		
		String id=request.getParameter("id");
		ra.addAttribute("id", id);
		
		return "redirect:memberInfo";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("id") String id, HttpSession session) {
		
		ms.delete(id);
		String view = logout(session);
		return view;
	}
	
	@GetMapping("findIdForm")
	public String findIdForm() {
		
		return "member/findIdForm";
	}
	
	@PostMapping("findId")
	public String findId(HttpServletRequest request, Model model) {
		
		String id=ms.findId(request);
		
		if(id!=null) {
			model.addAttribute("id", id);
			return "member/login";			
		}else {
			model.addAttribute("id", "1");
			return "member/findIdForm";
		}
		
	}
	
	@GetMapping("findPwForm")
	public String findPwForm() {
		
		return "member/findPwForm";
	}
	
	@PostMapping("findPw")
	public String findPw(HttpServletRequest request, Model model) {
		
		String pw=ms.findPw(request);
		System.out.println(pw);
		
		if(pw!=null) {
			model.addAttribute("pw", pw);
			return "member/login";			
		}else {
			model.addAttribute("pw", "1");
			return "member/findPwForm";
		}		
	}
}


















