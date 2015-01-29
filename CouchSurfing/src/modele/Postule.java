package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Postule {

	/**
	 * @return Liste des Postulation de l'utilisateur qui sont encore valides
	 * @throws SQLException
	 */
	public static ArrayList<Integer> getPostulationsEnCours(int theIdUser) throws SQLException{
		ArrayList<Integer> tablePostulation = new ArrayList<Integer>();
		Connection c = ConnectionMySQL.getInstance();
		PreparedStatement select = c.prepareStatement("SELECT IdOffre FROM Postule WHERE IdUtilisateur=? AND DateInvalidationAuto > CURDATE() ORDER BY DateInvalidationAuto"); //SORT BY DateInvalidationAuto
		select.setInt(1, theIdUser);
		ResultSet resultSelect=select.executeQuery();
		while(resultSelect.next()){
			tablePostulation.add(resultSelect.getInt(1));
		}
		return tablePostulation;
	}
	
	/**
	 * @return Liste des element supprimés
	 * @throws SQLException
	 */
	public static ArrayList<Integer> deletePostulationsPerimees(int theIdUser) throws SQLException{
		ArrayList<Integer> tablePostulation = new ArrayList<Integer>();
		Connection c = ConnectionMySQL.getInstance();
		//Selection des entrées a supprimer	
		PreparedStatement select = c.prepareStatement("SELECT IdOffre FROM Postule WHERE IdUtilisateur=? AND DateInvalidationAuto < CURDATE() ORDER BY DateInvalidationAuto"); //SORT BY DateInvalidationAuto
		select.setInt(1, theIdUser);
		ResultSet resultSelect=select.executeQuery();
		while(resultSelect.next()){
			tablePostulation.add(resultSelect.getInt(1));
		}
		//suppresion
		PreparedStatement delete = c.prepareStatement("DELETE FROM Postule WHERE IdOffre IN (SELECT * FROM (SELECT IdOffre FROM Postule WHERE IdUtilisateur=? AND DateInvalidationAuto < CURDATE()) AS ListePostulPerimee)");
		delete.setInt(1, theIdUser);
		int resultDelete = delete.executeUpdate();
		
		return tablePostulation;
	}
	
	/**
	 * @param theIdOffre
	 * @return succes
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public static boolean postulerAUneOffre(int theIdOffre, int theIdUser) throws SQLException {
		Date today = new Date();
		Date date = new Date(today.getYear(),today.getMonth()+2,today.getDay());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String myDate = sdf.format(date);
		
		Connection c=ConnectionMySQL.getInstance();
		PreparedStatement ps=c.prepareStatement("INSERT INTO Postule (IdUtilisateur,IdOffre,DateInvalidationAuto,Statut) values(?,?,?,?)");
		ps.setInt(1, theIdUser);
		ps.setInt(2, theIdOffre);
		ps.setString(3, myDate);
		ps.setInt(4, 3);
		if(ps.executeUpdate() == 1){
			return true;
		}		
		return false;
	}
}
