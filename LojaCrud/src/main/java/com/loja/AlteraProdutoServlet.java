package com.loja;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/alteraProduto")
public class AlteraProdutoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/*
	 * Danilo Gabriel cb3011798
	 * Gabriel Paulino cb3010635 
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
		System.out.println("Alterando Produto");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		int unidadeCompra = Integer.parseInt(request.getParameter("unidadeCompra"));
		String descricao = request.getParameter("descricao");
		double qtdPrevisoMes = Double.parseDouble(request.getParameter("qtdPrevisoMes"));
		double precoMaxComprado = Double.parseDouble(request.getParameter("precoMaxComprado"));
		
		Produtos produtos = new Produtos();
		Produto produto = produtos.getProdutoById(id);
		produto.setNome(nome);
		produto.setUnidadeCompra(unidadeCompra);
		produto.setDescricao(descricao);
		produto.setQtdPrevisoMes(qtdPrevisoMes);
		produto.setPrecoMaxComprado(precoMaxComprado);
		
		response.sendRedirect("listaProdutos");
		
	}	
}
