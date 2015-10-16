<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.domain.Provider"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Map<String, Object> maps=(Map<String, Object>)request.getAttribute("maps");
	List<Category> categoryList=(List<Category>)maps.get("categoryList");
	List<Provider> providerList=(List<Provider>)maps.get("providerList");
%>
<form action="doaddproduct.jsp" method="post">
	<table border="1" width="400" align="center">
		<tr>
			<td colspan="2" height="35" bgcolor="#00FFCC">&nbsp;添加产品</td>
		</tr>
		<tr>
			<td width="80">产品名</td>
			<td>
				<input type="text" name="productName"/>
			</td>
		</tr>
		<tr>
			<td width="80">进价</td>
			<td>
				<input type="text" name="incomePrice"/>
			</td>
		</tr>
		<tr>
			<td width="80">数量</td>
			<td>
				<input type="text" name="quantity"/>
			</td>
		</tr>
		<tr>
			<td width="80">售价</td>
			<td>
				<input type="text" name="salesPrice"/>
			</td>
		</tr>
		<tr>
			<td width="80">供应商</td>
			<td>
				<select name="providerId">
				<%
					for(int i=0;i<providerList.size();i++)
					{
						Provider provider=providerList.get(i);
				%>
						<option value="<%=provider.getProviderId()%>"><%=provider.getProviderName()%></option>
				<%		
					}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td width="80">类别</td>
			<td>
				<select name="categoryId">
				<%
					for(int i=0;i<categoryList.size();i++)
					{
						Category category=categoryList.get(i);
				%>
						<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>
				<%		
					}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td width="80"></td>
			<td>
				<input type="submit" value="添加产品"/>
			</td>
		</tr>
	</table>
</form>

</body>
</html>