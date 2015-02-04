package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modele.Data;

public class TestConnnexionBDD {

	public static void main(String[] args) {
		Data.switchBDD_or_BDDTest(true);
		try {
			Statement s = Data.BDD_Connection.createStatement();
			ResultSet r=s.executeQuery("select Nom from Utilisateur");
			r.next();
			System.out.println(r.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}