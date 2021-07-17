package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract class ConnectionProvider {
	private static String urldb;
	private static String userdb;
	private static String passworddb;
	private static Connection con;

	
	static {
		urldb = Settings.getProperty("urldb");
		userdb = Settings.getProperty("userdb");
		passworddb = Settings.getProperty("passworddb");

	}

	public static Connection getConnection() throws SQLException {
		if (con == null || con.isClosed()) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				con = DriverManager.getConnection(urldb, userdb, passworddb);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}

	public static void close() throws SQLException {
		if (con != null) {
			con.close();
		}
	}
}
