<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">
		<h1>Costumer Management</h1>
		<h2>
			<a href="newCostumer">Add New Costumer</a> &nbsp;&nbsp;&nbsp; 
			<a href=listCostumer>List All Costumer</a> &nbsp;&nbsp;&nbsp; 
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
				<th>Comissão</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${costumerList}" var="costumer">
				<tr>
					<td><c:out value="${costumer.id}" /></td>
					<td><c:out value="${costumer.custName}" /></td>
					<td><c:out value="${costumer.city}" /></td>
					<td><c:out value="${costumer.grade}" /></td>
					<td><c:out value="${costumer.salesmanId}" /></td>				
					<td><a href="editCostumer?id=<c:out value='${costumer.id}'/>">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; 
						<a href="deleteCostumer?id=<c:out value='${costumer.id}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>