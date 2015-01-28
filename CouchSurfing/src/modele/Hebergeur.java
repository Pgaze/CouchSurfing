package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hebergeur {

	private int idHebergeur;
	private int telephone;
	private String adresse;
	private int indiceConfort;
	

	/**
	 * @return telephone
	 */
	public int getTelephone() {
		return telephone;
	}


	/**
	 * @param telephone
	 */
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}


	/**
	 * @return adresse
	 */
	public String getAdresse() {
		return adresse;
	}


	/**
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	/**
	 * @return indiceConfort
	 */
	public int getIndiceConfort() {
		return indiceConfort;
	}


	/**
	 * @param indiceConfort
	 */
	public void setIndiceConfort(int indiceConfort) {
		this.indiceConfort = indiceConfort;
	}


	/**
	 * @param telephone
	 * @param adresse
	 * @param indiceConfort
	 */
	public Hebergeur(int telephone, String adresse, int indiceConfort) {
		this.idHebergeur=getIdHebergeur();
		this.telephone = telephone;
		this.adresse = adresse;
		this.indiceConfort = indiceConfort;
	}
	
	
	/**
	 * ConstructeurVide
	 */
	public Hebergeur(){
		
	}


	/**
	 * @return idHebergeur
	 */
	public int getIdHebergeur() {
		return this.idHebergeur;
	}
	
	public void setIdHebergeur(int theId){
		this.idHebergeur=theId;
	}
	
	public boolean inserDansLaBase() throws SQLException{
		Connection c=ConnectionMySQL.getInstance();
		PreparedStatement ps=c.prepareStatement("insert into Hebergeur (IdHebergeur,Adresse) values(?,?)");
		ps.setInt(1, this.getIdHebergeur());
		ps.setString(2, "");
		if(ps.executeUpdate() ==1){
			return true;
		}
		return false;

	}


	/** Retrouve l'id de l'utilisateur qui a un tel id hebergeur
	 * @param idHebergeur
	 * @return id de l'utilisateur s'il existe, 0 sinon
	 * @throws SQLException
	 */
	public int getIdUtilisateurByIdHebergeur(int idHebergeur) throws SQLException {
		Connection c = ConnectionMySQL.getInstance();
		PreparedStatement select = c.prepareStatement("select IdUtilisateur from Utilisateur where Hebergeur=? ");
		select.setInt(1, this.getIdHebergeur());
		ResultSet resultSelect = select.executeQuery();
		if(resultSelect.next()){
			return resultSelect.getInt(1);
		}
		return 0;
	}
	
	public void deleteHebergeurInBDD() throws SQLException{
		Connection c = ConnectionMySQL.getInstance();
		PreparedStatement delete = c.prepareStatement("DELETE FROM Hebergeur WHERE IdHebergeur IN (SELECT * FROM (SELECT IdHebergeur FROM Hebergeur WHERE IdHebergeur=?");
		delete.setInt(1, this.getIdHebergeur());
		ResultSet resultDelete = delete.executeQuery();
		/*if(resultDelete.deleteRow()){
			System.out.println("Succes");
		}else
			System.out.println("Failed to delete IdHebergeur : "+ this.getIdHebergeur());
			*/
	}
}