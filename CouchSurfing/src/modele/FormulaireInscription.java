package modele;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;


public class FormulaireInscription {

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
	
	
}
