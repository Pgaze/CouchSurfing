package modele;

public class Offre {

	private Logement logement;
	private Utilisateur hebergeur;
	private String dateDebut,dateFin;
	
	public Offre(Logement logement, Utilisateur hebergeur, String dateDebut, String dateFin) {
		this.setLogement(logement);
		this.setHebergeur(hebergeur);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
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
	
	

}
