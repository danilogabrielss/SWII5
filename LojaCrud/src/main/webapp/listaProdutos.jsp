<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${not empty produto}">
		Produto ${ produto } cadastrada com sucesso!
	</c:if>

	<h3>Lista de Produtos:</h3>

	<ul>
		<c:forEach items="${produtos}" var="produto">

			<li>
			ID: ${produto.id }</br>
			Nome: ${produto.nome }</br>
			Unidade Compra: ${produto.unidadeCompra }</br>
			Descricao: ${produto.descricao }</br>
			Quantidade Prevista no Mes: ${produto.qtdPrevisoMes }</br>
			Preco Maximo Comprado: ${produto.precoMaxComprado }
			<a href="/LojaCrud/mostraProduto?id=${produto.id }">edita</a>
			<a href="/LojaCrud/removeProduto?id=${produto.id }">remove</a>
			</br>
			</li>
		</c:forEach>
	</ul>
	
	<p>
		Danilo Gabriel cb3011798 <br /> Gabriel Paulino cb3010635
	</p>
	
</body>
</html>