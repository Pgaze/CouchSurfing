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
	public static ArrayList<Integer> getPostulationsEnCoursByUser(int theIdUser) throws SQLException{
		ArrayList<Integer> tablePostulation = new ArrayList<Integer>();
		PreparedStatement select = Data.BDD_Connection.prepareStatement("SELECT IdLogement FROM Postule "
				+ "WHERE IdUtilisateur=? AND DateInvalidite > CURDATE() ORDER BY DateInvalidite");
		select.setInt(1, theIdUser);
		ResultSet resultSelect=select.executeQuery();
		while(resultSelect.next()){
			tablePostulation.add(resultSelect.getInt(1));
		}
		return tablePostulation;
	}
	
	/**
	 * @return Liste des logements affectés
	 * @throws SQLException
	 */
	public static ArrayList<Integer> deletePostulationsPerimees() throws SQLException{
		ArrayList<Integer> table = getPostulationsPerimees();
		//suppresion
		PreparedStatement delete = Data.BDD_Connection.prepareStatement("DELETE FROM Postule WHERE DateInvalidite < CURDATE()");
		delete.executeUpdate();
		return table;
	}
	
	/**
	 * @return Liste des logements donc les postulations sont perimees
	 */
	public static ArrayList<Integer> getPostulationsPerimees() {
		ArrayList<Integer> tablePostulation = new ArrayList<Integer>();
		//Selection des entrées a supprimer	
		PreparedStatement select;
		try {
			select = Data.BDD_Connection.prepareStatement("SELECT IdLogement FROM Postule WHERE DateInvalidite < CURDATE() ORDER BY DateInvalidite");
			ResultSet resultSelect=select.executeQuery();
			while(resultSelect.next()){
				tablePostulation.add(resultSelect.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tablePostulation;
	}
	
	/**
	 * @return element supprimé
	 * @throws SQLException
	 */
	public static void deletePostulationByIdLogement(int idLogement) throws SQLException{
		//suppresion
		PreparedStatement delete = Data.BDD_Connection.prepareStatement("DELETE FROM Postule WHERE IdLogement=?");
		delete.setInt(1, idLogement);
		delete.executeUpdate();
	}
	
	/**
	 * @param theIdOffre
	 * @return status
	 * @throws SQLException
	 */
	@SuppressWarnings("deprecation")
	public static boolean postulerAUneOffre(int idLogement, int theIdUser) throws SQLException {
		Date today = new Date();
		Date date = new Date(today.getYear(),today.getMonth()+2,today.getDay());
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String myDate = sdf.format(date);
		
		PreparedStatement ps=Data.BDD_Connection.prepareStatement("INSERT INTO Postule (IdUtilisateur,IdLogement,DateInvalidite,Status) values(?,?,?,?)");
		ps.setInt(1, theIdUser);
		ps.setInt(2, idLogement);
		ps.setString(3, myDate);
		ps.setInt(4, 3);
		
		if(ps.executeUpdate() == 1){
			return true;
		}		
		return false;
	}
}
