<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Salesman</title>
</head>
<body>

	<div align="center">
		<h1>Salesman Management</h1>
		<h2>
			<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp;
		
			<a href="newSalesman">Add New Salesman</a> &nbsp;&nbsp;&nbsp; <a
				href="listSalesman">List All Salesman</a> &nbsp;&nbsp;&nbsp;
			<!-- <a href="creditos">Creditos</a>-->

		</h2>
		<table border="1" cellpadding="5">
			<caption>
				<h2>Salesman List</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Comissão</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${salesmanList}" var="salesman">
				<tr>
					<td><c:out value="${salesman.id}" /></td>
					<td><c:out value="${salesman.name}" /></td>
					<td><c:out value="${salesman.city}" /></td>
					<td><c:out value="${salesman.commission}" /></td>
					<td><a href="editSalesman?id=<c:out value='${salesman.id}'/>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteSalesman?id=<c:out value='${salesman.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
