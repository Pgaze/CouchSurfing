package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		this.idHebergeur= -1;
		this.telephone = telephone;
		this.adresse = adresse;
		this.indiceConfort = indiceConfort;
	}
	
	
	/**
	 * ConstructeurVide
	 */
	public Hebergeur(){
		this.idHebergeur= -1;
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
	 * @return statut
	 * @throws SQLException
	 */
	public boolean inserDansLaBase() throws SQLException{
		PreparedStatement ps=Data.connection.prepareStatement("insert into Hebergeur (IdHebergeur,Adresse) values(?,?)");
		ps.setInt(1, this.getIdHebergeur());
		ps.setString(2, "");
		if(ps.executeUpdate() ==1){
			return true;
		}
		return false;

	}

	/**
	 * @param theId
	 * @return Hebergeur avec les données trouvées dans la base
	 * @throws SQLException
	 */
	public static Hebergeur getHebergeurById(int theId) throws SQLException{
		Hebergeur result = new Hebergeur();
		PreparedStatement select = Data.connection.prepareStatement(""
				+ "select Telephone,IndiceConfort,Adresse from Hebergeur where IdHebergeur=?");
		select.setInt(1, theId);
		ResultSet rs=select.executeQuery();
		if(rs.next()){
			result.setTelephone(rs.getInt(1));
			result.setIndiceConfort(rs.getInt(2));
			result.setAdresse(rs.getString(3));
			result.setIdHebergeur(theId);
		}
		else{
			result = null;
		}
		return result;
	}

	/** Retrouve l'id de l'utilisateur qui a un tel id hebergeur
	 * @param idHebergeur
	 * @return id de l'utilisateur s'il existe, -1 sinon
	 * @throws SQLException
	 */
	public int getIdUtilisateurByIdHebergeur() throws SQLException {
		PreparedStatement select = Data.connection.prepareStatement("SELECT IdUtilisateur FROM Utilisateur WHERE Hebergeur=? ");
		select.setInt(1, this.getIdHebergeur());
		ResultSet resultSelect = select.executeQuery();
		if(resultSelect.next()){
			return resultSelect.getInt(1);
		}
		return -1;
	}
	
	/** Supprime l'Hebergeur de la table Hebergeur, et et a NULL le champ Hebergeur pour l'Utilisateur concerné
	 * @throws SQLException
	 */
	public void deleteHebergeurInBDD() throws SQLException{
		PreparedStatement delete = Data.connection.prepareStatement("DELETE FROM Hebergeur WHERE IdHebergeur IN (SELECT * FROM (SELECT IdHebergeur FROM Hebergeur WHERE IdHebergeur=?) AS ListHebergeur)");
		delete.setInt(1, this.getIdHebergeur());
		delete.executeUpdate();
		
		this.setIdHebergeur(-1);
	}


	@Override
	public String toString() {
		String result ="Le nom de ta maman";
		try {
			Utilisateur user =Utilisateur.getUtilisateurById(this.getIdUtilisateurByIdHebergeur());
			result = user.getFirstName() +" "+user.getName();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
