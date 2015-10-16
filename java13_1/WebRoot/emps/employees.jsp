<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.domain.Employees"%>
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
		员工管理。<Br/>
	</div>
</fieldset>

<a href="addemployee.jsp">添加员工</a>
<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>分类名</td>
		<td>分类描述</td>
		<td>操作</td>
	</tr>
<%
	//取得名字叫zw的集合
	PageModel<Employees> pageModel=(PageModel<Employees>)request.getAttribute("pageModel");
	List<Employees> employeeList=pageModel.getList();
	for(int i=0;i<employeeList.size();i++)
	{
		Employees employee=employeeList.get(i);
%>
		<tr>
			<td><%=employee.getEmpId() %></td>
			<td><%=employee.getEmpName() %></td>
			<td><%=employee.getHireDate() %></td>
			<td><%=employee.getSal() %></td>			
			<td>
				<a href="dofindemployee.jsp?employeeId=<%=employee.getEmpId() %>">修改</a>/<a href="dodeletecategory.jsp?employeeId=<%=employee.getEmpId() %>">删除</a>
			</td>
		</tr>	
<%
	}
%>
</table>
</body>
</html>