package net.javaguides.maven_web_project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.javaguides.maven_web_project.model.Salesman;

public class SalesmanDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public SalesmanDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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

	public List<Salesman> listAllSales() throws SQLException {
		List<Salesman> listSalesman = new ArrayList<>();

		String sql = "SELECT * FROM Salesman;";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("SALESMAN_ID");
			String name = resultSet.getString("NAME");
			String city = resultSet.getString("CITY");
			double commision = resultSet.getDouble("COMMISSION");

			Salesman salesman = new Salesman(id, name, city, commision);
			listSalesman.add(salesman);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listSalesman;
	}

	public Salesman getSalesman(int id) throws SQLException {
		Salesman salesman = null;
		String sql = "SELECT * FROM Salesman WHERE salesman_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String name = resultSet.getString("name");
			String city = resultSet.getString("city");
			float commission = resultSet.getFloat("commission");
			
			salesman = new Salesman(id, name, city, commission);
		}
		
		resultSet.close();
		statement.close();
		
		return salesman;
	}
	
	public boolean updateSalesman(Salesman salesman) throws SQLException {
		String sql = "UPDATE Salesman SET name = ?, city = ?, commission = ?";
		sql += " WHERE salesman_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, salesman.getName());
		statement.setString(2, salesman.getCity());
		statement.setDouble(3, salesman.getCommission());
		statement.setInt(4, salesman.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public boolean insertSalesman(Salesman salesman) throws SQLException {
		String sql = "INSERT INTO Salesman (name, city, commission) VALUES (?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, salesman.getName());
		statement.setString(2, salesman.getCity());
		statement.setDouble(3, salesman.getCommission());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public boolean deleteSalesman(Salesman salesman) throws SQLException {
		String sql = "DELETE FROM Salesman where salesman_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, salesman.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
}
