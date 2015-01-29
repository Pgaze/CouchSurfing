package modele;

import java.sql.Connection;

public final class Data {

	public static final String BDD_IP = "192.168.1.7";
	public static final String BDD_PWD = "teamBifle";
	public static final String BDD_USER = "serveur";
	public static final String BDD_PORT = "3306";
	public static Connection BDD_Connection = ConnectionMySQL.getInstance(false);
	
	public static void switchBDD_or_BDDTest(boolean inTest){
		Data.BDD_Connection=ConnectionMySQL.getInstance(inTest);
	}
}