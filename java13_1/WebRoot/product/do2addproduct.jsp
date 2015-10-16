<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.service.ProviderService"%>
<%@page import="com.pro.service.ProviderServiceImpl"%>
<%@page import="com.pro.service.CategoryService"%>
<%@page import="com.pro.service.CategoryServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Provider"%>
<%@page import="com.pro.service.ProductService"%>
<%@page import="com.pro.service.ProductServiceImpl"%>
<%@page import="java.util.Map"%>
<%
	
	//
	
	//
	ProductService productService=new ProductServiceImpl();
	Map<String, Object> maps=productService.findAllProviderCategory2Map();
	
	request.setAttribute("maps",maps);
	
	request.getRequestDispatcher("addproduct.jsp").forward(request,response);
%>