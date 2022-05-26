<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<c:url value="/novoProdutoCriado" var="linkServletNovaEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="post">
		ID: <input type="hidden" name="id" value="${produto.id }" /> <br />
		Nome: <input type="text" name="nome" value="${produto.nome }" /> <br />
		Unidade Compra: <input type="number" name="unidadeCompra"
			value="${produto.unidadeCompra }" /><br /> Descrição: <input
			type="text" name="descricao" value="${produto.descricao }" /><br />
		Quantidade Previsão Mes: <input type="number" name="qtdPrevisoMes"
			value="${produto.qtdPrevisoMes }" /><br /> Preço Máximo Comprado: <input
			type="number" name="precoMaxComprado"
			value="${produto.precoMaxComprado }" /> <br /> <input type="submit" />
	</form>

</body>
</html>