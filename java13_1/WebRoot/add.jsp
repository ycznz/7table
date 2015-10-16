<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="inc/sess.jsp" %>
<form action="doadd.jsp" method="post">
	<table border="1" width="400" align="center">
		<tr>
			<td colspan="2" height="35" bgcolor="#00FFCC">&nbsp;添加</td>
		</tr>
		<tr>
			<td width="80">用户名</td>
			<td>
				<input type="text" name="userName"/>
			</td>
		</tr>
		<tr>
			<td width="80">密码</td>
			<td>
				<input type="text" name="password"/>
			</td>
		</tr>
		<tr>
			<td width="80"></td>
			<td>
				<input type="submit" value="添加"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>