<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>Orders</title>
</head>
<body>

	<div align="center">
		<h1>Orders Management</h1>
		<h2>
			<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp;
		
			<a href="newOrders">Add New Orders</a> &nbsp;&nbsp;&nbsp; <a
				href="listOrders">List All Orders</a> &nbsp;&nbsp;&nbsp;
			<!-- <a href="creditos">Creditos</a>-->

		</h2>
		<table border="1" cellpadding="5">
			<caption>
				<h2>Orders List</h2>
			</caption>
			<tr>
				<th>Nº da ordem</th>
				<th>Purchase</th>
				<th>Data</th>
				<th>Costumer Id</th>
				<th>Salesman Id</th>
			</tr>
			<c:forEach items="${ordersList}" var="orders">
				<tr>
					<td><c:out value="${orders.ordNo}" /></td>
					<td><c:out value="${orders.purchase}" /></td>
					<td><c:out value="${orders.ordDate}" /></td>
					<td><c:out value="${orders.customerId}" /></td>
					<td><c:out value="${orders.salesmanId}" /></td>
					<td><a href="editOrders?ordNo=<c:out value='${orders.ordNo}'/>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteOrders?ordNo=<c:out value='${orders.ordNo}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
