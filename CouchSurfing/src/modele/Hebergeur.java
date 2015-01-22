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


	/**
	 * @param idHebergeur
	 */
	public void creerIdHebergeur(int idHebergeur) {
		Connection c = ConnectionMySQL.getInstance();
		PreparedStatement select = c.prepareStatement("select IdUtilisateur from Utilisateur where Mail=? and Nom=?");
		select.setString(1, this.mail);
		select.setString(2,this.name);
		ResultSet resultSelect = select.executeQuery();
		if(resultSelect.next()){
			this.idHebergeur = resultSelect.getInt(1);
		}
		else{	
			Statement count = c.createStatement();
			ResultSet resultCount = count.executeQuery("select count(IdHebergeur) from Hebergeur ");
			resultCount.next();
			this.idHebergeur = resultCount.getInt(1);

		}
	}
	
	
}
