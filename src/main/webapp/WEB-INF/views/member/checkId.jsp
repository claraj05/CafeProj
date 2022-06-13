<%@page import="com.web.root.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");
MemberDAO memberDAO = new MemberDAO();
boolean exist = memberDAO.isExistId(id);

request.setAttribute("exist", exist);
request.setAttribute("id", id);

RequestDispatcher dispatcher = request.getRequestDispatcher("checkIdResult.jsp");
dispatcher.forward(request, response);
%>




