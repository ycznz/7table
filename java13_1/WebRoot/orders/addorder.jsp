<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function ff(){
		//alert('hehe');
		window.showModalDialog("productiframe.jsp",window,"dialogWidth=300px;dialogHeight=250px;");
	}

	
	function totalPrice(){
		var sum=0;
		var mtab=document.getElementById("mtab");
		for(var i=0;i<mtab.rows.length;i++){
			var price=mtab.rows[i].cells[4].firstChild.nodeValue;
			price=parseInt(price);
			sum+=price;
			
		}
		document.getElementById("total").firstChild.nodeValue=sum;
	}

	function delete_row(v){
		//alert(v.rowIndex);
		var mtab=document.getElementById("mtab");
		mtab.deleteRow(v.rowIndex);
		totalPrice();		
	}

	function compu(obj){
		var op=obj.firstChild.nodeValue;
		//alert(op);
		var o=obj.parentNode.parentNode;
		//数量
		var num=o.cells[3].childNodes[1].value;

		if(op=='+'){
			num=parseInt(num)+1;
		}else{
			if(num<=1){
				num=1;
				return;
			}
			num=parseInt(num)-1;
		}
		

		//单价
		var price=o.cells[2].firstChild.nodeValue;
		o.cells[3].childNodes[1].value=num;
		//小计
		//var rowsum=obj.cells[4].firstChild.nodeValue;
		var rowsum=num*price;
		//obj.cells[3].childNodes[1].value;
		o.cells[4].firstChild.nodeValue=rowsum;
		//alert(num);
		totalPrice();

	}

	function rep(sno){
		var mtab=document.getElementById("mtab");
		for(var i=0;i<mtab.rows.length;i++){
			var no=mtab.rows[i].cells[0].firstChild.nodeValue;
			//no=parseInt(no);
			if(sno==no){
				//alert('不能重复选择。。');
				return true;
			}			
		}
		return false;
	}


	function js(){
		//alert('fdf');
	}
	//childNodes[1];
</script>

</head>
<body>
<%@include file="/inc/sess.jsp" %>
<form action="doaddorder.jsp" method="post">
<table>
	<tr>
		<td>
			客户编号:<input type="text" name="customerId" value="1000"/>
		</td>
		<td>
			员工号:<input type="text" name="empId" value="<%=emp.getEmpId() %>"/>
			名称：<input type="text" name="empName" value="<%=emp.getEmpName() %>"/>
		</td>
		<td>
			订单日期:<input type="text" name="orderDate" value="20151016"/>&nbsp;<a href="#" onclick="ff();return false;">选择商品</a>
		</td>
	</tr>	
</table>
<div>
	<table id="mtab" width="400"></table>
	合计：<label id="total">&nbsp;</label>
</div>
<input type="submit" value="订单提交"/>
</form>
</body>
</html>