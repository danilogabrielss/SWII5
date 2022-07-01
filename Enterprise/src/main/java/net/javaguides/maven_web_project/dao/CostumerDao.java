package net.javaguides.maven_web_project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.maven_web_project.model.Costumer;
import net.javaguides.maven_web_project.model.Salesman;

public class CostumerDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public CostumerDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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


	public List<Costumer> listAllCostumer() throws SQLException {
		List<Costumer> listCostumer = new ArrayList<>();

		String sql = "SELECT * FROM Costumers";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("COSTUMER_ID");
			String name = resultSet.getString("CUST_NAME");
			String city = resultSet.getString("CITY");
			int grade = resultSet.getInt("GRADE");
			int salesmanId = resultSet.getInt("SALESMAN_ID");

			Costumer costumer = new Costumer(id, name, city, grade, salesmanId);
			listCostumer.add(costumer);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listCostumer;
	}

	public Costumer getCostumer(int id) throws SQLException {
		Costumer costumer = null;
		String sql = "SELECT * FROM Costumer WHERE costumer_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String custName = resultSet.getString("custName");
			String city = resultSet.getString("city");
			int grade = resultSet.getInt("grade");
			int salesmanId = resultSet.getInt("salesmanId");
			
			costumer = new Costumer(id, custName, city, grade, salesmanId);
		}
		
		resultSet.close();
		statement.close();
		
		return costumer;
	}
	
	public boolean updateCostumer(Costumer costumer) throws SQLException {
		String sql = "UPDATE Costumer SET custName = ?, city = ?, grade = ?, salesman_id = ?";
		sql += " WHERE costumer_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, costumer.getCustName());
		statement.setString(2, costumer.getCity());
		statement.setInt(3, costumer.getGrade());		
		statement.setInt(4, costumer.getSalesmanId());
		statement.setInt(5, costumer.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public boolean insertCostumer(Costumer costumer) throws SQLException {
		String sql = "INSERT INTO book (custName, city, grade, salesman_id) VALUES (?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, costumer.getCustName());
		statement.setString(2, costumer.getCity());
		statement.setInt(3, costumer.getGrade());
		statement.setInt(4, costumer.getSalesmanId());

		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public boolean deleteCostumer(Costumer costumer) throws SQLException {
		String sql = "DELETE FROM Costumer where costumer_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, costumer.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	
}
