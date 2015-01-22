package tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modele.ConnectionMySQL;

public class TestConnnexionBDD {

	public static void main(String[] args) {
		try {
			Connection c=ConnectionMySQL.getInstance();
			Statement s = c.createStatement();
			ResultSet r=s.executeQuery("select Nom from Utilisateur");
			r.next();
			System.out.println(r.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
