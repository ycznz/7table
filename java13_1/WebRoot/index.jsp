<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.domain.Employees"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="1" height="100%">
	<tr>
		<td colspan="2" height="80" bgcolor="#0033CC">
			<%@include file="inc/sess.jsp" %>
			欢迎  ：<font color="yellow"><%=emp.getEmpName() %></font> 光临
		</td>
	</tr>
	<tr>
		<td width="180" valign="top">
			<iframe src="menu.jsp" width="100%" height="100%"></iframe>
		</td>
		<td>
			<iframe src="welcome.jsp" width="100%" height="100%" name="zw"></iframe>
		</td>
	</tr>
</table>
</body>
</html>