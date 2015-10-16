<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="com.pro.domain.Orders"%>
<%@page import="com.pro.domain.OrderDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.service.OrderService"%>
<%@page import="com.pro.service.OrderServiceImpl"%>
<%
Date dt=new Date();
String orderId=dt.getTime()+"";
orderId="110";
//1.1，取订单的数据
String customerId=request.getParameter("customerId");
String empId=request.getParameter("empId");
String orderDate=request.getParameter("orderDate");

Orders order=new Orders();
order.setCustomerId(Integer.parseInt(customerId));
order.setEmpId(Integer.parseInt(empId));
order.setOrderDate(orderDate);
order.setOrderId(Integer.parseInt(orderId));


//1.2,取明细的数据
String productIds[]=request.getParameterValues("productId");
String num[]=request.getParameterValues("num");

List<OrderDetails> detailList=new ArrayList<OrderDetails>();
for(int i=0;i<productIds.length;i++){
	OrderDetails orderDetails=new OrderDetails();
	orderDetails.setOrderId(Integer.parseInt(orderId));
	orderDetails.setProductId(Integer.parseInt(productIds[i]));
	orderDetails.setQuantity(Integer.parseInt(num[i]));
	
	detailList.add(orderDetails);
}
	
//2,调用业务层
OrderService orderService=new OrderServiceImpl();
orderService.addOrder(order,detailList);

//3,
request.getRequestDispatcher("doorders.jsp").forward(request,response);
%>