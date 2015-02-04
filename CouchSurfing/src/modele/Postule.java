package modele;

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
		PreparedStatement select = Data.BDD_Connection.prepareStatement("SELECT IdLogement FROM Postule WHERE IdUtilisateur=? AND DateInvalidite > CURDATE() ORDER BY DateInvalidite"); //SORT BY DateInvalidationAuto
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
	public static ArrayList<Integer> deletePostulationsPerimees() throws SQLException{
		ArrayList<Integer> tablePostulation = new ArrayList<Integer>();
		//Selection des entrées a supprimer	
		PreparedStatement select = Data.BDD_Connection.prepareStatement("SELECT * FROM Postule WHERE DateInvalidite < CURDATE() ORDER BY DateInvalidite"); //SORT BY DateInvalidationAuto
	
		ResultSet resultSelect=select.executeQuery();
		while(resultSelect.next()){
			tablePostulation.add(resultSelect.getInt(1));
		}
		//suppresion
		PreparedStatement delete = Data.BDD_Connection.prepareStatement("DELETE FROM Postule WHERE DateInvalidite < CURDATE()");
		int resultDelete = delete.executeUpdate();
		
		return tablePostulation;
	}
	
	/**
	 * @param theIdOffre
	 * @return succes
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public static boolean postulerAUneOffre(int IdLogement, int theIdUser) throws SQLException {
		Date today = new Date();
		Date date = new Date(today.getYear(),today.getMonth()+2,today.getDay());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String myDate = sdf.format(date);
		
		PreparedStatement ps=Data.BDD_Connection.prepareStatement("INSERT INTO Postule (IdUtilisateur,IdLogement,DateInvalidite,Statut) values(?,?,?,?)");
		ps.setInt(1, theIdUser);
		ps.setInt(2, IdLogement);
		ps.setString(3, myDate);
		ps.setInt(4, 3);
		
		if(ps.executeUpdate() == 1){
			return true;
		}		
		return false;
	}
}
