<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.domain.Category"%>
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

<a href="addcategory.jsp">添加分类</a>
<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>分类名</td>
		<td>分类描述</td>
		<td>操作</td>
	</tr>
<%
	//取得名字叫zw的集合
	PageModel<Category> pageModel=(PageModel<Category>)request.getAttribute("pageModel");
	List<Category> categoryList=pageModel.getList();
	for(int i=0;i<categoryList.size();i++)
	{
		Category category=categoryList.get(i);
%>
		<tr>
			<td><%=category.getCategoryId() %></td>
			<td><%=category.getCategoryName() %></td>
			<td><%=category.getCategoryDesc() %></td>
			<td>
				<a href="dofindcategory.jsp?categoryId=<%=category.getCategoryId() %>">修改</a>/<a href="dodeletecategory.jsp?categoryId=<%=category.getCategoryId() %>">删除</a>
			</td>
		</tr>	
<%
	}
%>
</table>
</body>
</html>