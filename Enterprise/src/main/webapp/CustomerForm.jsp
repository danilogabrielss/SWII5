<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Costumer</title>
</head>
<body>

	<center>
		<h1>Customer Management</h1>
		<h2>
			<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp; 
			<a	href="newCustomer">Add New Customer</a> &nbsp;&nbsp;&nbsp; 
			<a	href="listCustomer">List All Customer</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${costumer != null}">
			<form action="updateCustomer" method="post">
		</c:if>
		<c:if test="${costumer == null}">
			<form action="insertCustomer" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${customer != null}">
                        Edit Costumer
                    </c:if>
					<c:if test="${customer == null}">
                        Add New Costumer
                    </c:if>
				</h2>
			</caption>
			<c:if test="${customer != null}">
				<input type="hidden" name="id"
					value="<c:out value='${customer.id}' />" />
			</c:if>
			<tr>
				<th>Nome:</th>
				<td><input type="text" name="custName" size="45"
					value="<c:out value='${customer.custName}' />" />
				</td>
			</tr>
			<tr>
				<th>Cidade:</th>
				<td><input type="text" name="city" size="45"
					value="<c:out value='${customer.city}' />" />
				</td>
			</tr>
			<tr>
				<th>Grade:</th>
				<td><input type="number" name="grade" size="5"
					value="<c:out value='${customer.grade}' />" />
				</td>
			</tr>
			<tr>
				<th>Salesman Id:</th>
				<td><input type="number" name="salesmanId" size="5"
					value="<c:out value='${customer.salesmanId}' />" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>