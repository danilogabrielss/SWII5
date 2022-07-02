package net.javaguides.maven_web_project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.maven_web_project.model.Customer;
import net.javaguides.maven_web_project.model.Salesman;

public class CustomerDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public CustomerDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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


	public List<Customer> listAllCustomer() throws SQLException {
		List<Customer> listCustomer = new ArrayList<>();
		String sql = "SELECT * FROM Customer";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("CUSTOMER_ID");
			String name = resultSet.getString("CUST_NAME");
			String city = resultSet.getString("CITY");
			int grade = resultSet.getInt("GRADE");
			int salesmanId = resultSet.getInt("SALESMAN_ID");

			Customer customer = new Customer(id, name, city, grade, salesmanId);
			listCustomer.add(customer);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listCustomer;
	}

	public Customer getCustomer(int id) throws SQLException {
		Customer customer = null;
		String sql = "SELECT * FROM Customer WHERE customer_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String custName = resultSet.getString("CUST_NAME");
			String city = resultSet.getString("city");
			int grade = resultSet.getInt("grade");
			int salesmanId = resultSet.getInt("salesman_Id");
			
			customer = new Customer(id, custName, city, grade, salesmanId);
		}
		
		resultSet.close();
		statement.close();
		
		return customer;
	}
	
	public boolean updateCustomer(Customer customer) throws SQLException {
		String sql = "UPDATE Customer SET cust_name = ?, city = ?, grade = ?, salesman_id = ?";
		sql += " WHERE customer_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, customer.getCustName());
		statement.setString(2, customer.getCity());
		statement.setInt(3, customer.getGrade());		
		statement.setInt(4, customer.getSalesmanId());
		statement.setInt(5, customer.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public boolean insertCustomer(Customer customer) throws SQLException {
		String sql = "INSERT INTO Customer (cust_name, city, grade, salesman_id) VALUES (?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, customer.getCustName());
		statement.setString(2, customer.getCity());
		statement.setInt(3, customer.getGrade());
		statement.setInt(4, customer.getSalesmanId());

		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public boolean deleteCustomer(Customer customer) throws SQLException {
		String sql = "DELETE FROM Customer where customer_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, customer.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	
}
