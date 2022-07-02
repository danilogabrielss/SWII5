package net.javaguides.maven_web_project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.maven_web_project.model.Orders;

public class OrdersDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public OrdersDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = (Connection) DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public List<Orders> listAllOrders() throws SQLException {
		List<Orders> listOrders = new ArrayList<>();

		String sql = "SELECT * FROM Orders;";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("ORD_NO");
			double purchase = resultSet.getDouble("purch_amt");
			String ordDate = resultSet.getString("ord_date");
			int customerId = resultSet.getInt("customer_id");
			int salesmanId = resultSet.getInt("salesman_Id");

			Orders orders = new Orders(id, purchase, ordDate, customerId, salesmanId);
			listOrders.add(orders);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listOrders;
	}

	public Orders getOrders(int ordNo) throws SQLException {
		Orders orders = null;
		String sql = "SELECT * FROM Orders WHERE ORD_NO = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, ordNo);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			double purchase = resultSet.getDouble("purch_amt");
			String ordDate = resultSet.getString("ord_Date");
			int costumerId = resultSet.getInt("costumer_Id");
			int salesmanId = resultSet.getInt("salesman_Id");

			orders = new Orders(ordNo, purchase, ordDate, costumerId, salesmanId);
		}

		resultSet.close();
		statement.close();

		return orders;
	}

	public boolean updateOrders(Orders orders) throws SQLException {
		String sql = "UPDATE Orders SET purch_amt = ?, ord_Date = ?, customer_Id = ?, salesman_Id = ?";
		sql += " WHERE ORD_NO = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setDouble(1, orders.getPurchase());
		statement.setString(2, orders.getOrdDate());
		statement.setInt(3, orders.getCustomerId());
		statement.setInt(4, orders.getSalesmanId());
		statement.setInt(4, orders.getOrdNo());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;
	}

	public boolean insertOrders(Orders orders) throws SQLException {
		String sql = "INSERT INTO Orders (purch_amt, ord_Date, costumer_id, salesman_id) VALUES (?, ?, ?, ?)";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setDouble(1, orders.getPurchase());
		statement.setString(2, orders.getOrdDate());
		statement.setInt(3, orders.getCustomerId());
		statement.setInt(4, orders.getSalesmanId());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}

	public boolean deleteOrders(Orders orders) throws SQLException {
		String sql = "DELETE FROM Orders where ord_no = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, orders.getOrdNo());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;
	}

}
