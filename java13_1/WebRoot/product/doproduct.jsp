<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.service.UserService"%>
<%@page import="com.pro.service.UserServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.service.ProductService"%>
<%@page import="com.pro.service.ProductServiceImpl"%>
<%@page import="com.pro.domain.Product"%>
<%
	//1,
	String currentPage=request.getParameter("currentPage");
	if(currentPage==null||"".equals(currentPage)){
		currentPage="1";
	}
	//2,
	ProductService productService=new ProductServiceImpl();
	PageModel<Product> pageModel=productService.queryProducts(Integer.parseInt(currentPage),3);
	
	request.setAttribute("pageModel",pageModel);
	//3,
	request.getRequestDispatcher("product.jsp").forward(request,response);
%>