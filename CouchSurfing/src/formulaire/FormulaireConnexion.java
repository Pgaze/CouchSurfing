package formulaire;

import java.sql.SQLException;

import utilitaire.Password;
import modele.Utilisateur;

public class FormulaireConnexion {
	
	private String login;
	private String mdp;
		
	/**
	 * @param login
	 * @param mdp
	 */
	public FormulaireConnexion(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public FormulaireConnexion() {}

	/**
	 * @return status de validité
	 * @throws SQLException
	 */
	public boolean verificationCoupleMailMotDePasse() throws SQLException{
		Utilisateur user = Utilisateur.getUtilisateurParMail(this.getLogin());
		if(user!=null){
			return user.getPassword().contentEquals(Password.encrypt(this.getMdp()));
		}
		return false;
	}
}