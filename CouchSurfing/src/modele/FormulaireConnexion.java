package modele;

import java.sql.SQLException;

public class FormulaireConnexion {
	
	public boolean verificationCoupleMailMotDePasse(String mail,String motDePasse) throws SQLException{
		Utilisateur user = Utilisateur.getUtilisateurParMail(mail);
		return user.getPassword().contentEquals(motDePasse);
	}

}
