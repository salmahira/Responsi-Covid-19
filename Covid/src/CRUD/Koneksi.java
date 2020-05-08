package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
		public Connection getConnection() throws ClassNotFoundException, SQLException {
				Class.forName("com.mysql.cj.jdbc.Driver");
				return DriverManager.getConnection("jdbc:mysql://localhost/db_COVID19", "root", "root");
		}
}