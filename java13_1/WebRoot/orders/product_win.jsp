<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.pro.domain.Users"%>
<%@page import="com.pro.util.PageModel"%>
<%@page import="com.pro.domain.Category"%>
<%@page import="com.pro.domain.Provider"%>
<%@page import="com.pro.domain.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ff(v){
		//alert(v.getAttribute("sname"));

		var parentWin=window.parent.dialogArguments;
		//拿到父窗中的那个表格
		var mtab=parentWin.document.getElementById("mtab");
		mtab.setAttribute("border",1);
		//mtab.setAttribute("width",300);

		if(parentWin.rep(v.getAttribute("sno"))){
			alert('已选，不需重复。。');
			return;
		}

		//创建一行
		var row_=mtab.insertRow();
		row_.setAttribute("align","center");

		//创建列
		var cell_0=row_.insertCell(0);
		cell_0.innerHTML=v.getAttribute("sno")+'<input type="hidden" name="productId" value="'+v.getAttribute("sno")+'"/>';

		var cell_1=row_.insertCell(1);
		cell_1.innerHTML=v.getAttribute("sname")+'<input type="hidden" name="productName" value="'+v.getAttribute("sname")+'"/>';


		var cell_2=row_.insertCell(2);
		cell_2.innerHTML=v.getAttribute("sprice")+'<input type="hidden" name="price" value="'+v.getAttribute("sprice")+'"/>';

		var cell_3=row_.insertCell(3);
		cell_3.innerHTML='<a href="#" onclick="compu(this);return false;">—</a><input type="text" size="4" name="num" value="1"  readonly/><a href="#" onclick="compu(this);return false;">+</a>';

		var cell_4=row_.insertCell(4);
		cell_4.innerHTML=v.getAttribute("sprice");

		var cell_5=row_.insertCell(5);
		cell_5.innerHTML='<a href="#" onclick="delete_row(this.parentNode.parentNode)">移除</a>';

		parentWin.totalPrice();
		
	}

</script>
</head>
<body>
<fieldset>
	<legend>公告</legend>
	<div>
		管理。<Br/>
	</div>
</fieldset>

<table border="1" width="100%">
	<tr>
		<td>编号</td>
		<td>产品名</td>		
		<td>售价</td>				
	</tr>
<%
	//取得名字叫zw的集合
	PageModel<Product> pageModel=(PageModel<Product>)request.getAttribute("pageModel");
	List<Product> productList=pageModel.getList();
	for(int i=0;i<productList.size();i++)
	{
		Product product=productList.get(i);
%>
		<tr>
			<td><%=product.getProductId() %></td>
			<td>
				<a href="" sno="<%=product.getProductId() %>" sname="<%=product.getProductName()%>" sprice="<%=product.getSalesPrice()%>"  onclick="ff(this);return false;"><%=product.getProductName()%></a>
			</td>			
			<td><%=product.getSalesPrice()%></td>				
		</tr>	
<%
	}
%>
</table>
</body>
</html>