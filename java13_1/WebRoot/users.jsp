<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
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
		国庆来了。。大家吃好，喝好，玩好。。。<Br/>
	</div>
</fieldset>

<a href="add.jsp">添加用户</a>
<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>用户名</td>
		<td>密码</td>
		<td>操作</td>
	</tr>
<%
	//取得名字叫zw的集合
	List<Users> userList=(List<Users>)request.getAttribute("zw");
	for(int i=0;i<userList.size();i++)
	{
		Users user=userList.get(i);
%>
		<tr>
			<td><%=user.getUserId() %></td>
			<td><%=user.getUserName() %></td>
			<td><%=user.getPassword() %></td>
			<td>
				<a href="dofinduser.jsp?userId=<%=user.getUserId() %>">修改</a>/<a href="dodeleteuser.jsp?userId=<%=user.getUserId() %>" onclick="return confirm('真要删除吗？');">删除</a>
			</td>
		</tr>	
<%
	}
%>
</table>
</body>
</html>