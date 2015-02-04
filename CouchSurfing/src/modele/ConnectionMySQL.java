package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMySQL {
	private static Connection laConnection;


	private ConnectionMySQL() {
	}

	public static Connection getInstance(){
		try {

			Class.forName("com.mysql.jdbc.Driver");
			ConnectionMySQL.laConnection = DriverManager.getConnection(
					"jdbc:mysql://"+ Data.BDD_IP+":"+Data.BDD_PORT+Data.BDD_NAME, Data.BDD_USER,
					Data.BDD_PWD);
			ConnectionMySQL.laConnection.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erreur connexion BDD");
			e.printStackTrace();
			return null;
		}
		return ConnectionMySQL.laConnection;
	}

}
