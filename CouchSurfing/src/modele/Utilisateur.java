
package modele;

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
	private int idLogement;

	
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
		this.idLogement=0;
		this.setId();
	}

	public Utilisateur(String mail){
		this.mail=mail;
		this.idLogement=0;
	}

	public Utilisateur() {
	}

	public static Utilisateur getUtilisateurParMail(String mail) throws SQLException{
		Utilisateur result = new Utilisateur(mail);
		PreparedStatement select = Data.BDD_Connection.prepareStatement("" +
				"select Nom,Prenom,Mdp,Pseudo,IdLogement from Utilisateur where Mail=?");
		select.setString(1, mail);
		ResultSet rs=select.executeQuery();
		if(rs.next()){
			result.setName(rs.getString(1));
			result.setFirstName(rs.getString(2));
			result.setPassword(rs.getString(3));
			result.setPseudo(rs.getString(4));
			result.setIdLogement(rs.getInt(5));
			result.setId();
		}
		else{
			result =null;
		}
		return result;
	}
	
	public static Utilisateur getUtilisateurById(int idUtilisateur) throws SQLException{
		Utilisateur result = new Utilisateur();
		PreparedStatement select = Data.BDD_Connection.prepareStatement("" +
				"select Nom,Prenom,Mdp,Pseudo,IdLogement,Mail from Utilisateur where IdUtilisateur=?");
		select.setInt(1, idUtilisateur);
		ResultSet rs=select.executeQuery();
		if(rs.next()){
			result.setName(rs.getString(1));
			result.setFirstName(rs.getString(2));
			result.setPassword(rs.getString(3));
			result.setPseudo(rs.getString(4));
			result.setIdLogement(rs.getInt(5));
			result.setMail(rs.getString(6));
			result.setId();
		}
		else{
			result =null;
		}
		return result;
		
	}

	

	@Override
	public String toString() {
		return name + " " + firstName  ;
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
		PreparedStatement select=Data.BDD_Connection.prepareStatement("select IdUtilisateur from Utilisateur where Mail=? and Nom=?");
		select.setString(1, this.mail);
		select.setString(2,this.name);
		ResultSet resultSelect=select.executeQuery();
		if(resultSelect.next()){
			this.idUser=resultSelect.getInt(1);
		}
		else{	
			Statement count=Data.BDD_Connection.createStatement();
			ResultSet resultCount=count.executeQuery("select count(IdUtilisateur) from Utilisateur ");
			resultCount.next();
			this.idUser=resultCount.getInt(1);

		}
	}
	
	public boolean inserDansLaBase() throws SQLException{
		PreparedStatement ps=Data.BDD_Connection.prepareStatement("insert into Utilisateur (IdUtilisateur,Nom,Prenom,Mail,Pseudo,Mdp) values(?,?,?,?,?,?)");
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
	
	public int getIdLogement() {
		return idLogement;
	}
	
	public void setIdLogement(int theId){
		this.idLogement=theId;
	}

	
	 /** Cree 1 idHebergeur si l'utilisateur n'en possède pas, le retourne sinon
	  * 
	  * @throws SQLException 
	  * @throws Exception 
	  */
	 /*
	public int createIdLogement() throws SQLException {
		Logement hebergeur=new Logement();
		PreparedStatement select = Data.BDD_Connection.prepareStatement("select Hebergeur from Utilisateur where IdUtilisateur=? ");
		select.setInt(1, this.idUser);
		ResultSet resultSelect=select.executeQuery();
		if(resultSelect.next()){
			resultSelect.getInt(1); // Necessaire pour que le wasNull fonctionne ! >_<
			if (resultSelect.wasNull()) {
				Statement count = Data.BDD_Connection.createStatement();
				ResultSet resultCount = count.executeQuery("select count(IdHebergeur) from Hebergeur ");
				resultCount.next();
				
				this.idLogement = resultCount.getInt(1);
				hebergeur.setIdHebergeur(this.idLogement);
				hebergeur.inserDansLaBase();
				PreparedStatement update = Data.BDD_Connection.prepareStatement("update Utilisateur set Hebergeur=? where IdUtilisateur=?");
				update.setInt(1, this.idLogement);
				update.setInt(2, this.idUser);
				update.executeUpdate();
			}
		}
		
		return this.idLogement;
	}
	*/
}
