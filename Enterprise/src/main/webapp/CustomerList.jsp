<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
		<h1>Customer Management</h1>
		<h2>
			<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp;		
			<a href="newCustomer">Add New Customer</a> &nbsp;&nbsp;&nbsp; 
			<a href=listCustomer>List All Customer</a> &nbsp;&nbsp;&nbsp; 
			<!-- <a href="creditos">Creditos</a>-->

		</h2>
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

</body>
</html>