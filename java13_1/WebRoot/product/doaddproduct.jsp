<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.service.UserService"%>
<%@page import="com.pro.service.UserServiceImpl"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.service.CategoryServiceImpl"%>
<%@page import="com.pro.service.CategoryService"%>
<%@page import="com.pro.domain.Provider"%>
<%@page import="com.pro.service.ProviderService"%>
<%@page import="com.pro.service.ProviderServiceImpl"%>
<%@page import="com.pro.domain.Product"%>
<%@page import="com.pro.service.ProductService"%>
<%@page import="com.pro.service.ProductServiceImpl"%>
<%
	request.setCharacterEncoding("UTF-8");
	//三步曲。要记住，1，2，3
	//1,取表单数据，并封到对象中
	String productName=request.getParameter("productName");
	String incomePrice=request.getParameter("incomePrice");
	String quantity=request.getParameter("quantity");
	String salesPrice=request.getParameter("salesPrice");
	String providerId=request.getParameter("providerId");
	String categoryId=request.getParameter("categoryId");
	
	
	Product product=new Product();
	product.setCategoryId(Integer.parseInt(categoryId));
	product.setIncomePrice(Double.parseDouble(incomePrice));	
	product.setProductName(productName);
	product.setProviderId(Integer.parseInt(providerId));
	product.setQuantity(Integer.parseInt(quantity));
	product.setSalesPrice(Double.parseDouble(salesPrice));
	
	//2，调用业务层。就是过去我们写的client
	ProductService productService=new ProductServiceImpl();
	productService.addProduct(product);
	
	//3,跳转，成功后或失败，都要跳转到一个指定页面。
	//跳转方式有二：
	//1，转发,由request来处理的，可以带数据到转发目的地，并且url地址栏上的请求地址不变，
	//2，重定向，由response来处理，重新发请求到指定页面，
	response.sendRedirect("doproduct.jsp");
	
%>