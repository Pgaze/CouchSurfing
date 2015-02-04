package modele;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FormulaireProposerLogement {
	
	private String batimentEscalier;
	private String numeroEtVoie;
	private String cp;
	private String residence;
	private String complementAdresse;
	private String ville;
	private Utilisateur user;
	
	public FormulaireProposerLogement(String batimentEscalier,
			String numeroEtVoie, String cp, String residence,
			String complementAdresse, String ville, Utilisateur user) {
		super();
		this.batimentEscalier = batimentEscalier;
		this.numeroEtVoie = numeroEtVoie;
		this.cp = cp;
		this.residence = residence;
		this.complementAdresse = complementAdresse;
		this.ville = ville;
		this.user = user;
	}
	public String getBatimentEscalier() {
		return batimentEscalier;
	}
	public void setBatimentEscalier(String batimentEscalier) {
		this.batimentEscalier = batimentEscalier;
	}
	public String getNumeroEtVoie() {
		return numeroEtVoie;
	}
	public void setNumeroEtVoie(String numeroEtVoie) {
		this.numeroEtVoie = numeroEtVoie;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getComplementAdresse() {
		return complementAdresse;
	}
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Utilisateur getUser() {
		return user;
	}
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	public boolean verificationCp(){
		return this.cp.matches("[0-9]{5}");
	}
	
	public String procedureAjoutLogement() throws SQLException{
		String result="";
		Logement l=this.getLogement();
		boolean resultatInsertionLogement=l.insererDansLaBase();
		PreparedStatement insert=Data.BDD_Connection.prepareStatement("insert into Offre (idLogement,idHebergeur) values(?,?)");
		insert.setInt(1, l.getIdLogement());
		insert.setInt(2, this.user.createIdHebergeur());
		int res= insert.executeUpdate();
		if (res==1 && resultatInsertionLogement){
			result="Logement ajoute";
		}
		else{
			result="Echec création logement";
		}
		return result;
	}
	
	public Logement getLogement() throws SQLException{
		return new Logement(new Adresse(batimentEscalier, numeroEtVoie, cp, residence, complementAdresse, ville));
	}
	

}
