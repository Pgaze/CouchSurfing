package modele;

import java.sql.Connection;

public final class Data {

	public static final String BDD_IP = "192.168.1.17";
	public static final String BDD_PWD = "teamBifle";
	public static final String BDD_USER = "serveur";
	public static final String BDD_PORT = "3306";
	public static String BDD_NAME = "/CouchSurfing";
	public static Connection BDD_Connection = ConnectionMySQL.getInstance();
	
	/**
	 * @param inTest=true <=> BDD TEST, BDD normale sinon
	 */
	public static void switchBDD_or_BDDTest(boolean inTest){
		if(Data.BDD_NAME.contentEquals("/CouchSurfing") && inTest){
			Data.BDD_NAME="/CouchSurfingTestN";
		}else if(Data.BDD_NAME.equals("/CouchSurfingTestN") && !inTest){
			Data.BDD_NAME="/CouchSurfing";
		}
		Data.BDD_Connection=ConnectionMySQL.getInstance();
	}
}