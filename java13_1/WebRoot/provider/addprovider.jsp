<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="doaddprovider.jsp" method="post">
	<table border="1" width="400" align="center">
		<tr>
			<td colspan="2" height="35" bgcolor="#00FFCC">&nbsp;添加供应商</td>
		</tr>
		<tr>
			<td width="80">供应商名</td>
			<td>
				<input type="text" name="providerName"/>
			</td>
		</tr>
		<tr>
			<td width="80">供应商地址</td>
			<td>
				<input type="text" name="Address"/>
			</td>
		</tr>
		<tr>
			<td width="80">供应商电话</td>
			<td>
				<input type="text" name="tele"/>
			</td>
		</tr>
		<tr>
			<td width="80">帐号</td>
			<td>
				<input type="text" name="account"/>
			</td>
		</tr>
		<tr>
			<td width="80">email</td>
			<td>
				<input type="text" name="email"/>
			</td>
		</tr>
		
		<tr>
			<td width="80"></td>
			<td>
				<input type="submit" value="添加供应商"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>