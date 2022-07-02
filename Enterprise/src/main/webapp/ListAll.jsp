<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>List All </title>
</head>
<body>

	<div align="center">
	<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp;
		<h2>
			<!--<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp;
		
			<a href="newSalesman">Add New Salesman</a> &nbsp;&nbsp;&nbsp; <a
				href="listSalesman">List All Salesman</a> &nbsp;&nbsp;&nbsp;
			 <a href="creditos">Creditos</a>-->

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

	
	<div align="center">
			<!--<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp;		
			<a href="newCustomer">Add New Customer</a> &nbsp;&nbsp;&nbsp; 
			<a href=listCustomer>List All Customer</a> &nbsp;&nbsp;&nbsp; 
			 <a href="creditos">Creditos</a>-->

		<table border="1" cellpadding="5">
			<caption>
				<h2>Costumer List</h2>
			</caption>
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Grade</th>
				<th>Salesman Id:</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td><c:out value="${customer.id}" /></td>
					<td><c:out value="${customer.custName}" /></td>
					<td><c:out value="${customer.city}" /></td>
					<td><c:out value="${customer.grade}" /></td>
					<td><c:out value="${customer.salesmanId}" /></td>				
					<td><a href="editCustomer?id=<c:out value='${customer.id}'/>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="deleteCustomer?id=<c:out value='${customer.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

<div align="center">
			<!--<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp;
		
			<a href="newOrders">Add New Orders</a> &nbsp;&nbsp;&nbsp; <a
				href="listOrders">List All Orders</a> &nbsp;&nbsp;&nbsp;
			<a href="creditos">Creditos</a>-->

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
