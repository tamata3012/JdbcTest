package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String URL = "jdbc:postgresql://127.0.0.1:5432/testdb1";
    private static final String USER = "postgres";
    private static final String PASS = "0413";
	
	public static Connection getConnection() throws SQLException, Exception {
		Connection con=null;
		try {
//			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(URL, USER, PASS);
			con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
