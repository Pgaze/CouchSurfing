package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionMySQL {
	private static Connection laConnection;

	/**
	 * @return une instance de BDD_NAME (voir Data.switch...)
	 */
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

	/**
	 * @param inTest=true <=> BDD TEST, BDD normale sinon
	 * @throws SQLException 
	 */
	public static void switchBDD_or_BDDTest(boolean inTest) throws SQLException{
		if(Data.BDD_NAME.contentEquals("/CouchSurfing") && inTest){
			Data.BDD_NAME="/CouchSurfingTestN";
		}else if(Data.BDD_NAME.equals("/CouchSurfingTestN") && !inTest){
			Data.BDD_NAME="/CouchSurfing";
		}
		Data.BDD_Connection=null;
		Data.BDD_Connection=getInstance();
		if(Data.BDD_Connection==null)
			throw new SQLException ("Erreur de switch BDD");
	}

}
