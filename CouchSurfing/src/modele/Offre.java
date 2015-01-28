package modele;

public class Offre {

	private Logement logement;
	private Hebergeur hebergeur;
	private String dateDebut,dateFin;
	
	public Offre(Logement logement, Hebergeur hebergeur, String dateDebut,
			String dateFin) {
		super();
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

	public Hebergeur getHebergeur() {
		return hebergeur;
	}

	public void setHebergeur(Hebergeur hebergeur) {
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
