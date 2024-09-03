package jdbc.com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static String url="jdbc:mysql://localhost:3306/studentdatabase";
	private static String user="root";
	private static String pwd="root";
	private static Connection connection=null;
	
	public static Connection getDbConnection() throws SQLException {
		 connection=DriverManager.getConnection(url, user, pwd);
		return connection;
	}
	
	public static void closeDbConnection() throws SQLException {
		connection.close();
		System.out.println("Connection Closed");
	}
}
