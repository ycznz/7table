<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.domain.Provider"%>
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

<a href="addprovider.jsp">添加供应商</a>
<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>供应商名</td>
		<td>地址</td>
		<td>电话</td>
		<td>帐号</td>
		<td>email</td>
		<td>操作</td>
	</tr>
<%
	//取得名字叫zw的集合
	PageModel<Provider> pageModel=(PageModel<Provider>)request.getAttribute("pageModel");
	List<Provider> providerList=pageModel.getList();
	for(int i=0;i<providerList.size();i++)
	{
		Provider provider=providerList.get(i);
%>
		<tr>
			<td><%=provider.getProviderId() %></td>
			<td><%=provider.getProviderName()%></td>
			<td><%=provider.getAddress() %></td>
			<td><%=provider.getTele() %></td>
			<td><%=provider.getAccount() %></td>
			<td><%=provider.getEmail() %></td>
			<td>
				<a href="dofindprovider.jsp?providerId=<%=provider.getProviderId() %>">修改</a>/<a href="dodeleteprovider.jsp?providerId=<%=provider.getProviderId() %>">删除</a>
			</td>
		</tr>	
<%
	}
%>
</table>
</body>
</html>