package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMySQL {
	private static Connection laConnection;


	private ConnectionMySQL() {
	}

	
	public static Connection getInstance() throws SQLException{
		if (ConnectionMySQL.laConnection==null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				ConnectionMySQL.laConnection  = DriverManager.getConnection(
						"jdbc:mysql://169.254.9.164:3306/CouchSurfing", "serveur",
						"teamBifle");
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
		}
		ConnectionMySQL.laConnection.setAutoCommit(false);
		return ConnectionMySQL.laConnection;
	}
	
}
