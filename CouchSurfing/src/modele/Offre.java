package modele;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.directory.InvalidAttributeValueException;

public class Offre {

	private Logement logement;
	private Utilisateur hebergeur;
	private String dateDebut,dateFin;
	
	/**
	 * @param logement
	 * @param hebergeur
	 * @param dateDebut yyyy-mm-dd
	 * @param dateFin yyyy-mm-dd
	 */
	public Offre(Logement logement, Utilisateur hebergeur, String dateDebut, String dateFin) {
		this.setLogement(logement);
		this.setHebergeur(hebergeur);
		if(dateDebut != null && dateFin != null){
			try {
				checkIntegriteDates(dateDebut,dateFin);
				this.setDateDebut(dateDebut);
				this.setDateFin(dateFin);
			} catch (InvalidAttributeValueException | IllegalArgumentException e) {
				this.setDateDebut(null);
				this.setDateFin(null);
			}
		}		
	}

	/** Verifie l'integrite des dates debut et fin renseignées
	 * @param strDateDebut
	 * @param strDateFin
	 * @throws InvalidAttributeValueException
	 */
	private void checkIntegriteDates(String strDateDebut, String strDateFin) throws InvalidAttributeValueException {
		//reformatage de la date
		Date newDateDebut,newDateFin;
		newDateDebut = Date.valueOf(strDateDebut);
		newDateFin = Date.valueOf(strDateFin);
		//vérifications
		if(!newDateFin.after(newDateDebut))
			throw new InvalidAttributeValueException("La date de fin n'est pas postérieure a la date de début");
		Date dateCourante = new Date(System.currentTimeMillis());
		if(newDateDebut.before(dateCourante)) {
			//clean plein de truc dégueux
			Offre.cleanLogementByPostulePerimees();
			throw new InvalidAttributeValueException("La date de debut est antérieure ou égale a la date actuelle");
		}
	}

	/**
	 * @param year
	 * @param month
	 * @param day
	 * @return "yyyy-mm-dd"
	 * @throws InvalidAttributeValueException
	 */
	public static String creerStringDate(int year, int month, int day) throws InvalidAttributeValueException {
		String res = null;
		//vérification sommaire
		if(month <= 0 || day <= 0 || year <= 0 || day > 31 || month > 12){
			throw new InvalidAttributeValueException("La date avant changement de format est invalide");
		}else{
			res = "" + year + "-" + month + "-" + day;
		}
		return res;
	}

	/** Supprime les postulation perimees et met les date des logements concernes a null
	 * 
	 */
	private static void cleanLogementByPostulePerimees() {
		ArrayList<Integer> listLogements= new ArrayList<>();
		try {
			listLogements = Postule.getPostulationsPerimees();
			for(int logement : listLogements){				
				setDateToNull(Utilisateur.getUtilisateurByIdLogement(logement));
				Postule.deletePostulationByIdLogement(logement);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/** Met les dates du logement de l'utilisateur a null
	 * @param utilisateur
	 */
	private static void setDateToNull(Utilisateur utilisateur) {
		try {
			PreparedStatement update = Data.BDD_Connection.prepareStatement("UPDATE DateDebut,DateFin "
					+ "FROM Utilisateur WHERE IdUtilisateur=? ");
			update.setNull(1, java.sql.Types.DATE);
			update.setNull(2, java.sql.Types.DATE);
			update.setInt(3, utilisateur.getIdUser());
			update.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		String sql = "SELECT Utilisateur.idUtilisateur,DateDebut,DateFin "
				+ "FROM Logement,Utilisateur "
				+ "WHERE Utilisateur.IdLogement=Logement.IdLogement "
				+ "AND Logement.IdLogement=?";
		PreparedStatement select=Data.BDD_Connection.prepareStatement(sql);
		select.setInt(1, idLogement);
		ResultSet res=select.executeQuery();
		if(res.next()){
			return new Offre(Logement.getLogementById(idLogement), Utilisateur.getUtilisateurById(res.getInt(1)), res.getString(2), res.getString(3));
		}else{
			return null;
		}
	}
	
	

}
