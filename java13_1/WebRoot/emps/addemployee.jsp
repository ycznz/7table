<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="doaddemployee.jsp" method="post">
	<table border="1" width="400" align="center">
		<tr>
			<td colspan="2" height="35" bgcolor="#00FFCC">&nbsp;添加员工</td>
		</tr>
		<tr>
			<td width="80">员工姓名</td>
			<td>
				<input type="text" name="empName"/>
			</td>
		</tr>
		<tr>
			<td width="80">入职日期</td>
			<td>
				<input type="text" name="hireDate"/>
			</td>
		</tr>
		<tr>
			<td width="80">工资</td>
			<td>
				<input type="text" name="sal"/>
			</td>
		</tr>
		<tr>
			<td width="80">奖金等级</td>
			<td>
				<input type="text" name="commDate"/>
			</td>
		</tr>
		<tr>
			<td width="80"></td>
			<td>
				<input type="submit" value="添加员工"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>