<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 指定将数据以什么方式来提交到指定服务器 -->
<form action="dologin.jsp" method="post">
	<table border="1" width="400" align="center">
		<tr>
			<td colspan="2" height="35" bgcolor="#00FFCC">&nbsp;登录</td>
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
				<input type="password" name="password"/>
			</td>
		</tr>
		<tr>
			<td width="80"></td>
			<td>
				<input type="submit" value="登录"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>