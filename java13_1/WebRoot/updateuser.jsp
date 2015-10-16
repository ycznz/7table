<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.pro.domain.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Users user=(Users)request.getAttribute("user");
%>

<form action="doupdate.jsp" method="post">
	<table border="1" width="400" align="center">
		<tr>
			<td colspan="2" height="35" bgcolor="#00FFCC">&nbsp;修改</td>
		</tr>
		<tr>
			<td width="80">用户名</td>
			<td>
				<!-- 隐藏域，用来存储修改用户时的id -->
				<input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
				<input type="text" name="userName" value="<%=user.getUserName() %>"/>
			</td>
		</tr>
		<tr>
			<td width="80">密码</td>
			<td>
				<input type="text" name="password" value="<%=user.getPassword() %>"/>
			</td>
		</tr>
		<tr>
			<td width="80"></td>
			<td>
				<input type="submit" value="修改"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>