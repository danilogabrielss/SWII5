package com.loja;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/removeProduto")
public class RemoveProdutoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	/*
	 * Danilo Gabriel cb3011798
	 * Gabriel Paulino cb3010635 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(id);
		
		Produtos produtos = new Produtos();
		produtos.removeProduto(id);
		
		response.sendRedirect("listaProdutos");
	}
	
	
}
