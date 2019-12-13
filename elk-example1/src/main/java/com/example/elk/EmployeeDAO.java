package com.example.elk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class EmployeeDAO {
	protected static Logger logger = Logger.getLogger(EmployeeDAO.class);
	
	private static final String DB_FILENAME_PREFIX = "ELK_DB";
	private static final String DB_USERNAME = "ELK_USER";
	private static final String DB_PASSWORD = "ELK_PASS";
	
	static {
		try {
			//Load the HSQL Database Engine JDBC driver
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch (ClassNotFoundException e) {
			logger.error("Issue in loading HSQL db engine driver: " + e.getMessage());
		}
	}
	
	public EmployeeDAO() {
		try {
			Connection connection = getConnection();
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE employee (id INT NOT NULL, name VARCHAR(50) NOT NULL,"
					+ "email VARCHAR(50) NOT NULL, PRIMARY KEY (id))");
			connection.commit();
		} catch (SQLException e) {
			logger.error("Issue in creation of employee table: " + e.getMessage());
		}
	}

	public void addEmployee(Employee employee) throws Exception{
		Connection connection = null;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO employee VALUES ("+ employee.getEmpID() + ",'"+ employee.getName() +"', '" + employee.getEmailId() + "')");
			connection.commit();
		} finally {
			try {
				if(connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Issue in close DB: " + e.getMessage());
			}
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:hsqldb:" + DB_FILENAME_PREFIX, DB_USERNAME, DB_PASSWORD);
	}
}
