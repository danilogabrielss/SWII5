<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>Lista de Produtos</h2><br/>
	
	<ul>
		
		<c:forEach items="${prods}" var="produto">
		
		<li>
			${produto.nome }
		</li>
		
		</c:forEach>
		
	</ul>
	

</body>
</html>