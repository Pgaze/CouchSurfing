package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Offre {

	private Logement logement;
	private Utilisateur hebergeur;
	private String dateDebut,dateFin;
	
	public Offre(Logement logement, Utilisateur hebergeur, String dateDebut, String dateFin) {
		this.logement = logement;
		this.hebergeur = hebergeur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	

	public Logement getLogement() {
		return logement;
	}

	public void setLogement(Logement logement) {
		this.logement = logement;
	}

	public Utilisateur getHebergeur() {
		return hebergeur;
	}

	public void setHebergeur(Utilisateur hebergeur) {
		this.hebergeur = hebergeur;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}


	public static Offre getOffreByIdLogement(int idLogement) throws Exception {
		String sql = "SELECT Utilisateur.idUtilisateur,Logement.idLogement,DateDebut,DateFin "
				+ "FROM Logement,Utilisateur "
				+ "WHERE Utilisateur.IdLogement=Logement.IdLogement "
				+ "AND Logement.IdLogement=?";
		PreparedStatement select=Data.BDD_Connection.prepareStatement(sql);
		select.setInt(1, idLogement);
		ResultSet res=select.executeQuery();
		if(res.next()){
			return new Offre(Logement.getLogementById(idLogement), 
					Utilisateur.getUtilisateurById(res.getInt(1)), res.getString(3), res.getString(4));
		}
		else{
			return null;
		}
	}
	
	

}
