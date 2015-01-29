package modele;

import java.sql.Connection;

public final class Data {

	public static final String HOST_IP = "192.168.1.7";
	public static final String HOST_PWD = "teamBifle";
	public static final String BDD_USER = "serveur";
	public static final String BDD_PORT = "3306";
	public static final Connection connection = ConnectionMySQL.getInstance(false);
}