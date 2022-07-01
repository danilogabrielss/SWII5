<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/novoClienteCadastrado" var="linkServletNovoCliente"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Cliente</title>
</head>
<body>


	<form action="${linkServletNovoCliente}" method="post">
		ID: <input type="number" name="id" /> <br /> 
		Nome: <input type="text" name="custName" /> <br /> 
		Cidade: <input	type="text" name="city"><br /> 
		Avaliação: <input	type="number" name="grade"><br /> 
		ID do vendedor: <input	type="number" name="salesmanId"><br />
		<input	type="submit">
	</form>

	<p>
		Danilo Gabriel cb3011798 <br /> Gabriel Paulino cb3010635
	</p>

</body>
</html>