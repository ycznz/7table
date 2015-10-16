<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.pro.domain.Employees"%>
<%
	Employees emp = (Employees) session.getAttribute("emp");
	
	if (emp == null) {
		response.sendRedirect("login.jsp");
		return;
	}
%>