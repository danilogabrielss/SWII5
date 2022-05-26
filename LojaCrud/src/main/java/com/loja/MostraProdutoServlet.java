package com.loja;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mostraProduto")
public class MostraProdutoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/*
	 * Danilo Gabriel cb3011798
	 * Gabriel Paulino cb3010635 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	
	Produtos produtos = new Produtos();
	
	Produto produto = produtos.getProdutoById(id);
	
	System.out.println(produto.getId());
	
	request.setAttribute("produto", produto);
	
	RequestDispatcher rd = request.getRequestDispatcher("formAlteraProduto.jsp");
	rd.forward(request, response);
	
	}
}
