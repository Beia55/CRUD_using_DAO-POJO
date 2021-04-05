package ro.emanuel.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	// Metoda statica - exista si fara sa fie instantiat obiectul din clasa respectiva
	
	private static Connection con;
	public static Connection getConnection() throws SQLException{
		if(con==null || con.isClosed()) {
			Properties connectionProps = new Properties(); 
			connectionProps.put("user", "root"); 
			connectionProps.put("password","");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jdbc", 
								connectionProps);
		}
		return con;
	}
	
	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	
}

// Obictul exista o singura data, si are o zona de memorie alocata
// o varia este o referinta la acel obiect
