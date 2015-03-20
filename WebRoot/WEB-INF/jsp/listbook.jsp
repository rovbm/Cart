<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>listbook.jsp</title>
  </head>
  
  <body style="text-align: center;">
  <br>
  <h2>书籍列表</h2>
  <br><br>
  <table border="1" width="80%" align="center">
  	<tr>
  		<th>书籍编号</th>
  		<th>书名</th>
  		<th>作者</th>
  		<th>售价</th>
  		<th>描述</th>
  		<th>操作</th>
  	</tr>
  	
    <c:forEach var="me" items="${map}">
    <tr>
    	<td>${me.key}</td>
    	<td>${me.value.name}</td>
    	<td>${me.value.author}</td>
    	<td>${me.value.price}</td>
    	<td>${me.value.description}</td>
    	<td><a href="${pageContext.request.contextPath}/BuyServlet?bookid=${me.key}">购买</a></td>
	</tr>
    </c:forEach>
  </table>
  </body>
</html>
