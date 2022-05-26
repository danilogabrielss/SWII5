package com.loja;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaProdutos")
public class ListaProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Danilo Gabriel cb3011798
	 * Gabriel Paulino cb
	 */
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Produtos produtos = new Produtos();
		List<Produto> lista = produtos.getProduto();
		
		request.setAttribute("produtos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaProdutos.jsp");
		rd.forward(request, response);		
	}
}
