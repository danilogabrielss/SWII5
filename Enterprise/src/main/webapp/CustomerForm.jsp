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
		<h1>Salesman Management</h1>
		<h2>
			<a href="index">Back to Index</a> &nbsp;&nbsp;&nbsp; 
			<a	href="newCostumer">Add New Costumer</a> &nbsp;&nbsp;&nbsp; 
			<a	href="listSalesman">List All Costumer</a>

		</h2>
	</center>
	<div align="center">
		<c:if test="${costumer != null}">
			<form action="updateCostumer" method="post">
		</c:if>
		<c:if test="${costumer == null}">
			<form action="insertCostumer" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${costumer != null}">
                        Edit Costumer
                    </c:if>
					<c:if test="${costumer == null}">
                        Add New Costumer
                    </c:if>
				</h2>
			</caption>
			<c:if test="${salesman != null}">
				<input type="hidden" name="id"
					value="<c:out value='${costumer.id}' />" />
			</c:if>
			<tr>
				<th>Nome:</th>
				<td><input type="text" name="name" size="45"
					value="<c:out value='${costumer.name}' />" />
				</td>
			</tr>
			<tr>
				<th>Cidade:</th>
				<td><input type="text" name="city" size="45"
					value="<c:out value='${costumer.city}' />" />
				</td>
			</tr>
			<tr>
				<th>Grade:</th>
				<td><input type="text" name="commission" size="5"
					value="<c:out value='${costumer.grade}' />" />
				</td>
			</tr>
			<tr>
				<th>Salesman Id:</th>
				<td><input type="text" name="commission" size="5"
					value="<c:out value='${costumer.salesmanId}' />" />
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