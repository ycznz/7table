<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.service.UserService"%>
<%@page import="com.pro.service.UserServiceImpl"%>
<%
	request.setCharacterEncoding("UTF-8");
	//三步曲。要记住，1，2，3
	//1,取删除的链接中的?号后面的参数数据.
	String userId=request.getParameter("userId");
	
	
	//2，调用业务层。就是过去我们写的client
	UserService userService=new UserServiceImpl();
	userService.removeUser(Integer.parseInt(userId));
	
	//3,
	response.sendRedirect("dousers.jsp");
	
%>