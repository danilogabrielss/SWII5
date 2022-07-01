package net.javaguides.maven_web_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.maven_web_project.dao.CostumerDao;
import net.javaguides.maven_web_project.dao.SalesmanDao;
import net.javaguides.maven_web_project.model.Costumer;
import net.javaguides.maven_web_project.model.Salesman;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SalesmanDao salesmanDao;

	private CostumerDao costumerDao;

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

			case "/index":
				index(request, response);
				break;
			// Salesman
			case "/listSalesman":
				listSalesman(request, response);
				break;
			case "/newSalesman":
				formSalesman(request, response);
				break;
			case "/editSalesman":
				editSalesman(request, response);
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

			// Costumer
			case "/listCostumer":
				listCostumer(request, response);
				break;
			case "/newCostumer":
				newCostumer(request, response);
				break;
			case "/editCostumer":
				editCostumer(request, response);
				break;
			case "/updateCostumer":
				updateCostumer(request, response);
				break;
			case "/insertCostumer":
				insertCostumer(request, response);
				break;
			case "/deleteCostumer":
				deleteCostumer(request, response);
				break;

			/*
			 * case "/creditos": abrirCreditos(request, response); break;
			 */
			default:
				index(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
	}

	// Salesman

	private void listSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Salesman> salesmanList = salesmanDao.listAllSales();
		request.setAttribute("salesmanList", salesmanList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanList.jsp");
		dispatcher.forward(request, response);
	}

	private void formSalesman(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("SalesmanForm.jsp");
		dispatcher.forward(request, response);
	}

	private void editSalesman(HttpServletRequest request, HttpServletResponse response)
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
		response.sendRedirect("listarSalesman");
	}

	private void insertSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		double commission = Double.parseDouble(request.getParameter("commission"));

		Salesman newSalesman = new Salesman(name, city, commission);
		salesmanDao.insertSalesman(newSalesman);
		response.sendRedirect("listarSalesman");
	}

	private void deleteSalesman(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Salesman salesman = new Salesman(id);
		salesmanDao.deleteSalesman(salesman);
		response.sendRedirect("listarSalesman");

	}

	// Costumer
	private void listCostumer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Costumer> costumerList = costumerDao.listAllCostumer();
		request.setAttribute("costumerList", costumerList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("CostumerList.jsp");
		dispatcher.forward(request, response);
	}

	private void newCostumer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CostumerForm.jsp");
		dispatcher.forward(request, response);
	}

	private void editCostumer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Costumer existingCostumer = costumerDao.getCostumer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CostumerForm.jsp");
		request.setAttribute("costumer", existingCostumer);
		dispatcher.forward(request, response);

	}

	private void updateCostumer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String custName = request.getParameter("custName");
		String city = request.getParameter("city");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

		Costumer costumer = new Costumer(id, custName, city, grade, salesmanId);
		costumerDao.updateCostumer(costumer);
		response.sendRedirect("index");
	}

	private void insertCostumer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String custName = request.getParameter("custName");
		String city = request.getParameter("city");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

		Costumer newCostumer = new Costumer(custName, city, grade, salesmanId);
		costumerDao.insertCostumer(newCostumer);
		response.sendRedirect("index");
	}

	private void deleteCostumer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Costumer costumer = new Costumer(id);
		costumerDao.deleteCostumer(costumer);
		response.sendRedirect("index");
	}

	/*
	 * private void abrirCreditos(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException { RequestDispatcher dispatcher
	 * = request.getRequestDispatcher("creditos.jsp"); dispatcher.forward(request,
	 * response); }
	 */

}
