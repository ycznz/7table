<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.domain.Provider"%>
<%@page import="com.pro.domain.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>公告</legend>
	<div>
		分类管理。<Br/>
	</div>
</fieldset>

<a href="do2addproduct.jsp">添加产品</a>
<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>产品名</td>
		<td>进价</td>
		<td>售价</td>
		<td>数量</td>
		<td>类别</td>
		<td>供应商</td>
		<td>操作</td>
	</tr>
<%
	//取得名字叫zw的集合
	PageModel<Product> pageModel=(PageModel<Product>)request.getAttribute("pageModel");
	List<Product> productList=pageModel.getList();
	for(int i=0;i<productList.size();i++)
	{
		Product product=productList.get(i);
%>
		<tr>
			<td><%=product.getProductId() %></td>
			<td><%=product.getProductName()%></td>
			<td><%=product.getIncomePrice() %></td>
			<td><%=product.getSalesPrice()%></td>
			<td><%=product.getQuantity() %></td>
			<td><%=product.getCategoryId() %></td>
			<td><%=product.getProviderId() %></td>
			<td>
				<a href="dofindproduct.jsp?productId=<%=product.getProductId() %>">修改</a>/<a href="dodeleteproduct.jsp?productId=<%=product.getProductId() %>">删除</a>
			</td>
		</tr>	
<%
	}
%>
</table>
</body>
</html>