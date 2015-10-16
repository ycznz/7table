<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.service.OrderServiceImpl"%>
<%@page import="com.pro.service.OrderService"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.domain.Orders"%>
<%
	//
	//1,
	String currentPage=request.getParameter("currentPage");
	if(currentPage==null||"".equals(currentPage)){
		currentPage="1";
	}
	//
	OrderService orderService=new OrderServiceImpl();
	PageModel<Orders> pageModel=orderService.queryOrders(Integer.parseInt(currentPage),3);
	request.setAttribute("pageModel",pageModel);
	//3,
	request.getRequestDispatcher("orders.jsp").forward(request,response);
	//
	
%>