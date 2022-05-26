<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/novoProdutoCriado" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo Produto</title>
</head>
<body>


	<form action="${linkServletNovaEmpresa }" method="post">
		ID: <input type="number" name="id" /> <br /> 
		Nome: <input type="text" name="nome" /> <br /> 
			Unidade Compra: <input	type="number" name="unidadeCompra"><br /> 
			Descrição: <input	type="text" name="descricao"><br /> 
			Quantidade Previsão Mes: <input	type="number" name="qtdPrevisoMes"><br /> 
			Preço Máximo Comprado: <input type="number" name="precoMaxComprado"> <br /> 
		<input	type="submit">
	</form>

	<p>
		Danilo Gabriel cb3011798 <br /> Gabriel Paulino cb3010635
	</p>

</body>
</html>