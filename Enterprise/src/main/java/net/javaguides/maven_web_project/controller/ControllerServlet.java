package net.javaguides.maven_web_project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.maven_web_project.dao.CustomerDao;
import net.javaguides.maven_web_project.dao.OrdersDao;
import net.javaguides.maven_web_project.dao.SalesmanDao;
import net.javaguides.maven_web_project.model.Customer;
import net.javaguides.maven_web_project.model.Orders;
import net.javaguides.maven_web_project.model.Salesman;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SalesmanDao salesmanDao;

	private CustomerDao customerDao;
	
	private OrdersDao ordersDao;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL") + "?useTimezone=true&serverTimezone=UTC";
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		salesmanDao = new SalesmanDao(jdbcURL, jdbcUsername, jdbcPassword);
		customerDao = new CustomerDao(jdbcURL, jdbcUsername, jdbcPassword);
		ordersDao = new OrdersDao(jdbcURL, jdbcUsername, jdbcPassword);

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

			// Customer
			case "/listCustomer":
				listCustomer(request, response);
				break;
			case "/newCustomer":
				newCustomer(request, response);
				break;
			case "/editCustomer":
				editCustomer(request, response);
				break;
			case "/updateCustomer":
				updateCustomer(request, response);
				break;
			case "/insertCustomer":
				insertCustomer(request, response);
				break;
			case "/deleteCustomer":
				deleteCustomer(request, response);
				break;

			// Customer
			case "/listOrders":
				listOrders(request, response);
				break;
			case "/newOrders":
				newOrders(request, response);
				break;
			case "/editOrders":
				editOrders(request, response);
				break;
			case "/updateOrders":
				updateOrders(request, response);
				break;
			case "/insertOrders":
				insertOrders(request, response);
				break;
			case "/deleteOrders":
				deleteOrders(request, response);
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
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customer> customerList = customerDao.listAllCustomer();
		request.setAttribute("customerList", customerList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerList.jsp");
		dispatcher.forward(request, response);
	}

	private void newCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
		dispatcher.forward(request, response);
	}

	private void editCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Customer existingCustomer = customerDao.getCustomer(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CustomerForm.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);

	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String custName = request.getParameter("custName");
		String city = request.getParameter("city");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

		Customer customer = new Customer(id, custName, city, grade, salesmanId);
		customerDao.updateCustomer(customer);
		response.sendRedirect("listCustomer");
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String custName = request.getParameter("custName");
		String city = request.getParameter("city");
		int grade = Integer.parseInt(request.getParameter("grade"));
		int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

		Customer newCustomer = new Customer(custName, city, grade, salesmanId);
		customerDao.insertCustomer(newCustomer);
		response.sendRedirect("listCustomer");
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Customer customer = new Customer(id);
		customerDao.deleteCustomer(customer);
		response.sendRedirect("listCustomer");
	}
		
	//Orders	
	private void listOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Orders> ordersList = ordersDao.listAllOrders();
		request.setAttribute("ordersList", ordersList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersList.jsp");
		dispatcher.forward(request, response);
	}

	private void newOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersForm.jsp");
		dispatcher.forward(request, response);
	}

	private void editOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int ordNo = Integer.parseInt(request.getParameter("ordNo"));
		Orders existingOrders= ordersDao.getOrders(ordNo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("OrdersForm.jsp");
		request.setAttribute("orders", existingOrders);
		dispatcher.forward(request, response);

	}

	private void updateOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		/*int ordNo = Integer.parseInt(request.getParameter("ordNo"));
		double purchase = Double.parseDouble(request.getParameter("purchase"));
		Date ordDate = Date.parse(request.getParameter("ordDate"));
		int costumerId = Integer.parseInt(request.getParameter("costumerId"));
		int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

		Orders orders = new Orders(ordNo, purchase, ordDate, costumerId, salesmanId);
		ordersDao.updateOrders(orders);*/
		response.sendRedirect("listOrders");
	}

	private void insertOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		double purchase = Double.parseDouble(request.getParameter("purchase"));
		String ordDate = (request.getParameter("ordDate"));
		int costumerId = Integer.parseInt(request.getParameter("costumerId"));
		int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

		Orders newOrders = new Orders(purchase, ordDate, costumerId, salesmanId);
		ordersDao.insertOrders(newOrders);
		response.sendRedirect("listCustomer");
	}

	private void deleteOrders(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int ordNo = Integer.parseInt(request.getParameter("ordNo"));

		Orders orders = new Orders(ordNo);
		ordersDao.deleteOrders(orders);
		response.sendRedirect("listCustomer");
	}
		
	
	/*
	 * private void abrirCreditos(HttpServletRequest request, HttpServletResponse
	 * response) throws IOException, ServletException { RequestDispatcher dispatcher
	 * = request.getRequestDispatcher("creditos.jsp"); dispatcher.forward(request,
	 * response); }
	 */

}
