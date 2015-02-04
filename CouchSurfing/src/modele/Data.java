package modele;

import java.sql.Connection;

public final class Data {

	public static final String BDD_IP = "192.168.1.7";
	public static final String BDD_PWD = "teamBifle";
	public static final String BDD_USER = "bastien";
	public static final String BDD_PORT = "3306";
	public static String BDD_NAME = "/CouchSurfing";
	public static Connection BDD_Connection = ConnectionMySQL.getInstance();
	
	public static void switchBDD_or_BDDTest(boolean inTest){
		if(Data.BDD_NAME.contentEquals("/CouchSurfing") && inTest){
			Data.BDD_NAME="/CouchSurfingTest";
		}else if(Data.BDD_NAME.equals("/CouchSurfingTest") && !inTest){
			Data.BDD_NAME="/CouchSurfing";
		}else{
			System.out.println("Erreur switch BDD");
		}
		Data.BDD_Connection=ConnectionMySQL.getInstance();
	}
}