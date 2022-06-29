<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Salesman</title>
</head>
<body>	
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>
				<h2>Salesman List</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Comissão</th>
			</tr>
			<c:forEach var="book" items="${salesmanList}">
				<tr>
					<td><c:out value="${salesmanList.id}" /></td>
					<td><c:out value="${salesmanList.name}" /></td>
					<td><c:out value="${salesmanList.city}" /></td>
					<td><c:out value="${salesmanList.commission}" /></td>
					<td><a href="edit?id=<c:out value='${salesmanList.id}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="delete?id=<c:out value='${salesmanList.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
