package pl.coderslab.garage.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static String url = "jdbc:mysql://localhost:3306/garage?useSSL=false";
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String username = "root";
	private static String password = "coderslab";
	private static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
			}
		} catch (ClassNotFoundException ex) {
		}
		return con;
	}
}
