<<<<<<< HEAD
package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {

	private int idUser;
	private String mail;
	private String password;
	private String name;
	private String firstName;
	private String pseudo;
	private int idHebergeur;

	
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
		this.idHebergeur=0;
		this.setId();
	}

	public Utilisateur(String mail){
		this.mail=mail;
		this.idHebergeur=0;
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
	
	public boolean inserDansLaBase() throws SQLException{
		Connection c=ConnectionMySQL.getInstance();
		PreparedStatement ps=c.prepareStatement("insert into Utilisateur (IdUtilisateur,Nom,Prenom,Mail,Pseudo,Mdp,Nsecu) values(?,?,?,?,?,?,156)");
		ps.setInt(1, this.idUser);
		ps.setString(2, this.name);
		ps.setString(3, this.firstName);
		ps.setString(4, this.mail);
		ps.setString(5, this.pseudo);
		ps.setString(6, this.password);
		if(ps.executeUpdate() ==1){
			return true;
		}
		return false;

	}
	
	public int getIdHebergeur() {
		return idHebergeur;
	}
	
	public void setIdHebergeur(int theId){
		this.idHebergeur=theId;
	}

	/**
	 * Set l idHebergeur avec un id existant s il y en a un, sinon en cree un
	 * @throws SQLException 
	 */
	public int createIdHebergeur() throws SQLException {
		Hebergeur hebergeur=new Hebergeur();
		Connection c = ConnectionMySQL.getInstance();
		PreparedStatement select = c.prepareStatement("select Hebergeur from Utilisateur where IdUtilisateur=? ");
		select.setInt(1, this.idUser);
		ResultSet resultSelect=select.executeQuery();
		if(resultSelect.next()){
			if(resultSelect.getInt(1)==0){
				//TODO : chercher int null
			}
		}
		Statement count = c.createStatement();
		ResultSet resultCount = count.executeQuery("select count(IdHebergeur) from Hebergeur ");
		resultCount.next();
		
		this.idHebergeur = resultCount.getInt(1);
		hebergeur.setIdHebergeur(this.idHebergeur);
		hebergeur.inserDansLaBase();

		return this.idHebergeur;
	}

}
=======
package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilisateur {

	private int idUser;
	private String mail;
	private String password;
	private String name;
	private String firstName;
	private String pseudo;
	private int idHebergeur;

	
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
		this.idHebergeur=0;
		this.setId();
	}

	public Utilisateur(String mail){
		this.mail=mail;
		this.idHebergeur=0;
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
	
	public boolean inserDansLaBase() throws SQLException{
		Connection c=ConnectionMySQL.getInstance();
		PreparedStatement ps=c.prepareStatement("insert into Utilisateur (IdUtilisateur,Nom,Prenom,Mail,Pseudo,Mdp,Nsecu) values(?,?,?,?,?,?,156)");
		ps.setInt(1, this.idUser);
		ps.setString(2, this.name);
		ps.setString(3, this.firstName);
		ps.setString(4, this.mail);
		ps.setString(5, this.pseudo);
		ps.setString(6, this.password);
		if(ps.executeUpdate() ==1){
			return true;
		}
		return false;

	}
	
	public int getIdHebergeur() {
		return idHebergeur;
	}
	
	public void setIdHebergeur(int theId){
		this.idHebergeur=theId;
	}

	/**
	 * Set l idHebergeur avec un id existant s il y en a un, sinon en cree un
	 * @throws SQLException 
	 */
	public int createIdHebergeur() throws SQLException {
		Connection c = ConnectionMySQL.getInstance();
		PreparedStatement select = c.prepareStatement("select IdHebergeur from Utilisateur where IdHebergeur=? ");
		select.setInt(1, this.getIdHebergeur());
		ResultSet resultSelect = select.executeQuery();
		if(resultSelect.next()){
			this.idHebergeur = resultSelect.getInt(1);
		}
		else{
			Statement count = c.createStatement();
			ResultSet resultCount = count.executeQuery("select count(IdHebergeur) from Hebergeur ");
			resultCount.next();
			this.idHebergeur = resultCount.getInt(1);
		}
		return this.idHebergeur;
	}

}
>>>>>>> 9b8c6360f3f8183b6798b63311bb643f4c22a488

