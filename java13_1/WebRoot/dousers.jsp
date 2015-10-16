<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.service.UserService"%>
<%@page import="com.pro.service.UserServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
<%
	//1,
	
	//2,
	UserService userService=new UserServiceImpl();
	List<Users> userList=userService.findAllUser();
	
	request.setAttribute("zw",userList);
	
	//3,
	request.getRequestDispatcher("users.jsp").forward(request,response);
%>