package modele;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionMySQL {
	private static Connection laConnection;


	private ConnectionMySQL() {
	}

	
	public static Connection getInstance(){
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
		return ConnectionMySQL.laConnection;
	}
	
}
