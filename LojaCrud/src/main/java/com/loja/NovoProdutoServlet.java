package com.loja;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/novoProduto")
public class NovoProdutoServlet extends HttpServlet {

	/*
	 * Danilo Gabriel cb3011798 Gabriel Paulino cb3010635
	 */

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Cadastrando novo Produto");

		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
		String descricao = request.getParameter("descricao");
		double qtdPrevisoMes = Double.parseDouble(request.getParameter("qtdPrevisoMes"));
		double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));

		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setUnidadeCompra(unidadeCompra);
		produto.setDescricao(descricao);
		produto.setQtdPrevisoMes(qtdPrevisoMes);
		produto.setPrecoMaxComprado(precoMaxComprado);

		Produtos produtos = new Produtos();
		produtos.adiciona(produto);

		RequestDispatcher rd = request.getRequestDispatcher("novoProdutoCriado.jsp");
		request.setAttribute("produto", produto.getNome());
		rd.forward(request, response);
		//response.sendRedirect("listaProdutos");
	}

}
