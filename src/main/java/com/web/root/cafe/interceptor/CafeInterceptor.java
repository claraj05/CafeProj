package com.web.root.cafe.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.web.root.session.name.MemberSession;

public class CafeInterceptor extends HandlerInterceptorAdapter implements MemberSession {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		HttpSession session = request.getSession();
		if(session.getAttribute(LOGIN) == null) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 작성이 가능합니다');"+
					"location.href='" + request.getContextPath() + "/member/login'</script>");
			return false;
			
		}
		return true;
	}

}
