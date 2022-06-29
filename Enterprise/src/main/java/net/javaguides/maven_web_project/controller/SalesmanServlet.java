package net.javaguides.maven_web_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.maven_web_project.dao.SalesmanDao;
import net.javaguides.maven_web_project.model.Salesman;

@WebServlet(urlPatterns = "/salesman")
public class SalesmanServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private SalesmanDao salesmanDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Salesman> salesmanList = null;
		try {
			salesmanList = salesmanDao.listAllSales();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("salesmanList", salesmanList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
		dispatcher.forward(request, response);
	}

}
