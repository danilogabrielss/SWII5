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

		String sql = "SELECT * FROM salesman";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt("SALESMAN_ID");
			String nome = resultSet.getString("NAME");
			String cidade = resultSet.getString("CITY ");
			int comissao = resultSet.getInt("COMMISSION");

			Salesman salesman = new Salesman(id, nome, cidade, comissao);
			listSalesman.add(salesman);
		}

		resultSet.close();
		statement.close();

		disconnect();

		return listSalesman;
	}

}
