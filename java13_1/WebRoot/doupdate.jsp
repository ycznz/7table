<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.service.UserService"%>
<%@page import="com.pro.service.UserServiceImpl"%>
<%
	request.setCharacterEncoding("UTF-8");
	//三步曲。要记住，1，2，3
	//1,取表单数据，并封到对象中
	String userId=request.getParameter("userId");
	String userName=request.getParameter("userName");
	String password=request.getParameter("password");
	
	Users user=new Users();
	user.setUserId(Integer.parseInt(userId));
	user.setUserName(userName);
	user.setPassword(password);
	
	//2，调用业务层。就是过去我们写的client
	UserService userService=new UserServiceImpl();
	userService.editUser(user);		
	
	//3,跳转，
	response.sendRedirect("dousers.jsp");
	
%>