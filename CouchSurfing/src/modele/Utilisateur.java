package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {

	private String mail;
	private String password;
	private String name;
	private String firstName;
	private int idUser;
	private String pseudo;
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @param mail
	 * @param password
	 * @param name
	 * @param firstName
	 * @throws SQLException 
	 */
	public Utilisateur(String mail, String password, String name, String firstName,String pseudo) throws SQLException {
		this.mail = mail;
		this.password = password;
		this.name = name;
		this.firstName = firstName;
		this.pseudo=pseudo;
		this.setId();
	}

	public Utilisateur(String mail){
		this.mail=mail;
	}

	public static Utilisateur getUtilisateurParMail(String mail) throws SQLException{
		Utilisateur result = new Utilisateur(mail);
		PreparedStatement select = ConnectionMySQL.getInstance().prepareStatement("" +
				"select Nom,Prenom,Mdp,Pseudo from Utilisateur where Mail=?");
		select.setString(1, mail);
		ResultSet rs=select.executeQuery();
		if(rs.next()){
			result.setName(rs.getString(1));
			result.setFirstName(rs.getString(2));
			result.setPassword(rs.getString(3));
			result.setPseudo(rs.getString(4));
			result.setId();
		}
		else{
			result =null;
		}
		return result;
	}


	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}



	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}



	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	/**
	 * @return the idUser
	 */
	public int getIdUser() {
		return idUser;
	}



	private void setId() throws SQLException {
		Connection c=ConnectionMySQL.getInstance();
		PreparedStatement select=c.prepareStatement("select IdUtilisateur from Utilisateur where Mail=? and Nom=?");
		select.setString(1, this.mail);
		select.setString(2,this.name);
		ResultSet resultSelect=select.executeQuery();
		if(resultSelect.next()){
			this.idUser=resultSelect.getInt(1);
		}
		else{	
			Statement count=c.createStatement();
			ResultSet resultCount=count.executeQuery("select count(IdUtilisateur) from Utilisateur ");
			resultCount.next();
			this.idUser=resultCount.getInt(1);

		}
	}

}
