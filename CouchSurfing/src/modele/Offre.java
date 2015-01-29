package modele;

public class Offre {

	private int idOffre;
	private Logement logement;
	private Hebergeur hebergeur;
	private String dateDebut,dateFin;
	
	public Offre(int idOffre, Logement logement, Hebergeur hebergeur, String dateDebut, String dateFin) {
		this.idOffre = idOffre;
		this.logement = logement;
		this.hebergeur = hebergeur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public int getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
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
