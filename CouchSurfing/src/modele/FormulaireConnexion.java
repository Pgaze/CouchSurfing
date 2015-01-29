package modele;

import java.sql.SQLException;

public class FormulaireConnexion {
	
	private String login;
	private String mdp;
		
	public FormulaireConnexion(String login, String mdp) {
		super();
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



	public FormulaireConnexion() {
	}

	public boolean verificationCoupleMailMotDePasse() throws SQLException{
		Utilisateur user = Utilisateur.getUtilisateurParMail(this.login);
		if(user!=null){
			return user.getPassword().contentEquals(this.mdp);	
		}
		return false;
	}

}
