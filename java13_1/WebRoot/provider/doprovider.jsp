<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.service.UserService"%>
<%@page import="com.pro.service.UserServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.service.CategoryService"%>
<%@page import="com.pro.service.CategoryServiceImpl"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.service.ProviderService"%>
<%@page import="com.pro.service.ProviderServiceImpl"%>
<%@page import="com.pro.domain.Provider"%>
<%
	//1,
	String currentPage=request.getParameter("currentPage");
	if(currentPage==null||"".equals(currentPage)){
		currentPage="1";
	}
	//2,
	ProviderService providerService=new ProviderServiceImpl();
	PageModel<Provider> pageModel=providerService.queryProviders(Integer.parseInt(currentPage),3);
	
	request.setAttribute("pageModel",pageModel);
	//3,
	request.getRequestDispatcher("provider.jsp").forward(request,response);
%>