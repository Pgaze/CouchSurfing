package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FormulaireInscription {
	
	//Valeur des champs du formulaire
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String confirmMdp;
	private String pseudo;
	
	

	public FormulaireInscription(String nom, String prenom, String mail,
			String mdp, String confirmMdp, String pseudo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.confirmMdp = confirmMdp;
		this.pseudo=pseudo;
	}

	public FormulaireInscription() {
	}

	public boolean verificationDonnesInscription(String prenom,String nom,String pseudo,String mail,String motDePasse) throws SQLException{
		boolean result = true;
		Utilisateur aTester=new Utilisateur(mail, motDePasse, nom, prenom, pseudo);
		result=this.testMotDePasseValide(aTester.getPassword());
		result=this.testMailValide(aTester.getMail());
		return result;
	}

	public boolean testMailValide(String mailATester) {
		return mailATester.matches("^[a-zA-Z0-9]+(@){1}[a-z]+(\\.){1}([a-z]{2,4})");
	}

	public boolean testMotDePasseValide(String motDePasseATester) {
		boolean contientMaj =motDePasseATester.matches(".*[A-Z].*");
		boolean contientMin =motDePasseATester.matches(".*[a-z].*");
		boolean contientChiffre =motDePasseATester.matches(".*[0-9].*");
		boolean longueurOk = motDePasseATester.length()>7 && motDePasseATester.length()<30;
		return  longueurOk && contientMaj && contientMin && contientChiffre;
	}
	
	public int insererUtilisateurDansLaBase(Utilisateur user) throws SQLException{
		Connection c=ConnectionMySQL.getInstance();
		PreparedStatement ps=c.prepareStatement("insert into Utilisateur (IdUtilisateur,Nom,Prenom,Mail,Pseudo,Mdp,Nsecu) values(?,?,?,?,?,?,156)");
		ps.setInt(1, user.getIdUser());
		ps.setString(2, user.getName());
		ps.setString(3, user.getFirstName());
		ps.setString(4, user.getMail());
		ps.setString(5, user.getPseudo());
		ps.setString(6, user.getPassword());
		return ps.executeUpdate();
	
	}

	public String procedureInscription() throws SQLException {
			if(!this.confirmMdp.contentEquals(this.mdp)){
				return "Probleme confirmation mot de passe";
			}
			else if(!this.testMailValide(this.mail)){
				return "Adresse mail invalide";
			}
			else if (this.testUtilisateurExistant(this.mail)){
				return "Utilisateur existant";
			}
			else if(!this.testMotDePasseValide(mdp)){
				return "Mot de passe invalide";
			}
			else{
				this.getUtilisateur().inserDansLaBase();
				ConnectionMySQL.getInstance().commit();
				String s= "Bienvenue sur machin";
				GestionMail.send("clicknsleep@gmail.com", this.getUtilisateur().getMail(), "Inscription à ClickAndSleep.co.uk réussie", s);
				GestionMail.send(this.getUtilisateur().getMail(),"clicknsleep@gmail.com" , "Nouvelle inscription sur le site", this.getUtilisateur().getFirstName()+" "+this.getUtilisateur().getName() +"s'est inscrit");
				return "Inscription reussie";
			}
	}

	
	
	private boolean testUtilisateurExistant(String mail) throws SQLException {
		PreparedStatement s=ConnectionMySQL.getInstance().prepareStatement("select nom from Utilisateur where mail=?");
		s.setString(1, mail);
		ResultSet r=s.executeQuery();
		return r.next();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getMail() {
		return mail;
	}

	public String getMdp() {
		return mdp;
	}

	public String getConfirmMdp() {
		return confirmMdp;
	}

	public String getPseudo() {
		return pseudo;
	}


	private Utilisateur getUtilisateur() throws SQLException {
		return new Utilisateur(this.mail, this.mdp, this.nom, this.prenom, this.pseudo);
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public void setConfirmMdp(String confirmMdp) {
		this.confirmMdp = confirmMdp;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
}