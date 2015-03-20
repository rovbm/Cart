<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<!--  
  <head>
    <title>listcart.jsp</title>
    <script type="text/javascript">
    	function clearCart() {
    		if(confirm("您确定要清空购物车吗？")){
				window.location.href = "${pageContext.request.contextPath}/ClearCartServlet";
			}
		}
		
		function deleteBook(bookid) {
			if(confirm("您确定要删除这本书吗？")){
				window.location.href = "${pageContext.request.contextPath}/DeleteServlet?bookid="+bookid;
			}
		}
		
		function setQuantity(bookid, input, oldValue) {
			if(input.value>=1 && input.value<=100){
				if(confirm("您确定改为"+input.value+"本吗？")){
					window.location.href = "${pageContext.request.contextPath}/SetQuantityServlet?bookid="+bookid+"&quantity="+input.value;
				}else{
					input.value = oldValue;
				}
			}else{
				alert("必须输入1-100之间的整数！");
				input.value = oldValue;
			}
		}
    </script>
  </head>
  
  <body style="text-align: center;">
  <br>
  <h2>购物车列表</h2>
  <br><br>
  <c:if test="${!empty(cart.map)}">
  <table border="1" width="80%" align="center">
	<tr>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>
    <c:forEach var="me" items="${cart.map}">
    <tr>
		<td>${me.value.book.name}</td>
		<td>${me.value.book.author}</td>
		<td>${me.value.book.price}</td>
		<td width="168px"><input type="text" name="quantity" size="15" value="${me.value.quantity}" onchange="setQuantity(${me.key},this,${me.value.quantity})">本</td>
		<td>${me.value.price}</td>
		<td><a href="javascript:deleteBook(${me.key})">删除</a></td>
	</tr>
    </c:forEach>
    <tr>
    	<td colspan="3" align="left"><input type="button" value="清空购物车" onclick="clearCart()"></td>
    	<td colspan="3" align="right">总金额：${cart.price}</td>
    </tr>
  </table>
  </c:if>
  <c:if test="${empty(cart.map)}">
  	对不起，您还没有购买任何东西！
  </c:if>
  
  </body>
-->




<head>
	<title>listcart.jsp</title>
	<script type="text/javascript">
		function decrease(id,button) {
			var value = document.getElementById("input"+id).value;
			if(value>1){
				document.getElementById("input"+id).value--;
				value = document.getElementById("input"+id).value;
				window.location.href = "${pageContext.request.contextPath}/SetQuantityServlet?bookid="+id+"&quantity="+value;
				if(value<=99){
					document.getElementById("in"+id).disabled=null;
				}
			}else{
				 button.disabled="disabled";
			}
		}
		function increase(id,button) {
			var value = document.getElementById("input"+id).value;
			if(value<=99){
				document.getElementById("input"+id).value++;
				value = document.getElementById("input"+id).value;
				window.location.href = "${pageContext.request.contextPath}/SetQuantityServlet?bookid="+id+"&quantity="+value;
				if(value>1){
					document.getElementById("de"+id).disabled=null;
				}
			}else{
				 button.disabled="disabled";
			}
		}
		
		function setQuantity(bookid, input, oldValue) {
			if(input.value>=1 && input.value<=100){
				if(confirm("您确定改为"+input.value+"本吗？")){
					window.location.href = "${pageContext.request.contextPath}/SetQuantityServlet?bookid="+bookid+"&quantity="+input.value;
				}else{
					input.value = oldValue;
				}
			}else{
				alert("必须输入1-100之间的整数！");
				input.value = oldValue;
			}
		}
		
		function clearCart() {
    		if(confirm("您确定要清空购物车吗？")){
				window.location.href = "${pageContext.request.contextPath}/ClearCartServlet";
			}
		}
		function deleteBook(bookid) {
			if(confirm("您确定要删除这本书吗？")){
				window.location.href = "${pageContext.request.contextPath}/DeleteServlet?bookid="+bookid;
			}
		}
	</script>
</head>

<body style="text-align: center;">
  <br>
  <h2>购物车列表</h2>
  <br><br>
  <c:if test="${!empty(cart.map)}">
  <table border="1" width="80%" align="center">
	<tr>
		<th>书名</th>
		<th>作者</th>
		<th>单价</th>
		<th>数量</th>
		<th>小计</th>
		<th>操作</th>
	</tr>
    <c:forEach var="me" items="${cart.map}">
    <tr>
		<td>${me.value.book.name}</td>
		<td>${me.value.book.author}</td>
		<td>${me.value.book.price}</td>
		<td width="150px">
			<input type="button" id="de${me.key}" value="-" onclick="decrease(${me.key},this)">
			<input type="text" id="input${me.key}" size="4" value="${me.value.quantity}" onchange="setQuantity(${me.key},this,${me.value.quantity})">
			<input type="button" id="in${me.key}" value="+" onclick="increase(${me.key},this)">
		</td>
		<td>${me.value.price}</td>
		<td><a href="javascript:deleteBook(${me.key})">删除</a></td>
	</tr>
    </c:forEach>
    <tr>
    	<td colspan="3" align="left"><input type="button" value="清空购物车" onclick="clearCart()"></td>
    	<td colspan="3" align="right">总金额：${cart.price}</td>
    </tr>
  </table>
  </c:if>
  <c:if test="${empty(cart.map)}">
  	对不起，您还没有购买任何东西！
  </c:if>
  
  </body>

</html>
