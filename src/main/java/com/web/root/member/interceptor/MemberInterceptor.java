package com.web.root.member.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.web.root.session.name.MemberSession;

public class MemberInterceptor extends HandlerInterceptorAdapter implements MemberSession{

	@Override//프리핸들 오버라이드로 로그인되있을 때만 글 작성할 수 있도록 함 (작성 후 servlet context에서 만들기)
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session= request.getSession();
		if(session.getAttribute(LOGIN)==null) { //로그인 상태 아니면
			response.setContentType("text/html; charset=utf-8"); //html작성
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 작성가능');"//안된다고 알림
						+"location.href='"+request.getContextPath()+"/member/login'</script>");
			return false;
		}
		return true;
	}
	
	
	
	
}
