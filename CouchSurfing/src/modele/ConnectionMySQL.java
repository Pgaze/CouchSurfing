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
						"jdbc:mysql://"+ Data.HOST_IP+":"+Data.BDD_PORT+"/CouchSurfing", Data.BDD_USER,
						Data.HOST_PWD);
			}
			catch(Exception exc){
				exc.printStackTrace();
			}
		}
		ConnectionMySQL.laConnection.setAutoCommit(false);
		return ConnectionMySQL.laConnection;
	}
	
}
