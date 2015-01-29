package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modele.Data;

public class TestConnnexionBDD {

	public static void main(String[] args) {
		try {
			Statement s = Data.connection.createStatement();
			ResultSet r=s.executeQuery("select Nom from Utilisateur");
			r.next();
			System.out.println(r.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
