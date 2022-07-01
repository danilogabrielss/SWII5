package net.javaguides.maven_web_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.maven_web_project.dao.SalesmanDao;
import net.javaguides.maven_web_project.model.Salesman;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SalesmanDao salesmanDao;

	// private CostumerDao costumerDao;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL") + "?useTimezone=true&serverTimezone=UTC";
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		salesmanDao = new SalesmanDao(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/listarSalesman":
				listSalesman(request, response);
				break;
			case "/newSalesman":
				showNewFormSalesman(request, response);
				break;
			case "/editSalesman":
				showEditForm(request, response);
				break;
			case "/updateSalesman":
				updateSalesman(request, response);
				break;

			case "/insertSalesman":
				insertSalesman(request, response);
				break;
			case "/deleteSalesman":
				deleteSalesman(request, response);
				break;

			/*
			 * case "/creditos": abrirCreditos(request, response); break;
			 */
			default:
				listSalesman(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Salesman> salesmanList = salesmanDao.listAllSales();
		request.setAttribute("list", salesmanList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewFormSalesman(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Salesman existingSalesman = salesmanDao.getSalesman(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
		request.setAttribute("salesman", existingSalesman);
		dispatcher.forward(request, response);

	}

	private void updateSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		double commission = Double.parseDouble(request.getParameter("commission"));

		Salesman salesman = new Salesman(id, name, city, commission);
		salesmanDao.updateSalesman(salesman);
		response.sendRedirect("list");
	}

	private void insertSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		double commission = Double.parseDouble(request.getParameter("commission"));

		Salesman newSalesman = new Salesman(name, city, commission);
		salesmanDao.insertSalesman(newSalesman);
		response.sendRedirect("list");
	}
	
	  
	  private void deleteSalesman(HttpServletRequest request, HttpServletResponse
	  response) throws SQLException, IOException { 
	  int id = Integer.parseInt(request.getParameter("id"));
	  
	  Salesman salesman = new Salesman(id);
	  salesmanDao.deleteSalesman(salesman);
	  response.sendRedirect("list");
	  
	  }
	  
	 /* private void abrirCreditos(HttpServletRequest request, HttpServletResponse
	  response) throws IOException, ServletException { RequestDispatcher dispatcher
	  = request.getRequestDispatcher("creditos.jsp"); dispatcher.forward(request,
	  response); }
	 */

}
