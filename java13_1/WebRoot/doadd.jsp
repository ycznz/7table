<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.service.UserService"%>
<%@page import="com.pro.service.UserServiceImpl"%>
<%
	request.setCharacterEncoding("UTF-8");
	//三步曲。要记住，1，2，3
	//1,取表单数据，并封到对象中
	String userName=request.getParameter("userName");
	String password=request.getParameter("password");
	
	Users user=new Users();
	user.setUserName(userName);
	user.setPassword(password);
	
	//2，调用业务层。就是过去我们写的client
	UserService userService=new UserServiceImpl();
	userService.saveUser(user);
	
	
	
	//3,跳转，成功后或失败，都要跳转到一个指定页面。
	//跳转方式有二：
	//1，转发,由request来处理的，可以带数据到转发目的地，并且url地址栏上的请求地址不变，
	//2，重定向，由response来处理，重新发请求到指定页面，
	response.sendRedirect("dousers.jsp");
	
%>