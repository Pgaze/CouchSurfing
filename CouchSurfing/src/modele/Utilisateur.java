
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
	 * @param mail
	 * @param password
	 * @param name
	 * @param firstName
	 * @throws SQLException 
	 */
	public Utilisateur(String mail, String password, String name, String firstName,String pseudo) throws SQLException {
		this.setMail(mail);
		this.setPassword(password);
		this.setName(name);
		this.setFirstName(firstName);
		this.setPseudo(pseudo);
		this.setIdLogement(0);
		this.setId();
	}

	public Utilisateur(String mail){
		this.mail=mail;
		this.idLogement=0;
	}

	public Utilisateur() {}

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
	
	/**
	 * @param idUtilisateur
	 * @return l'utilisateur
	 * @throws SQLException
	 */
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
	
	@Override
	public String toString() {
		return name + " " + firstName  ;
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
	
	public int getIdPhotoProfil() throws SQLException{
		String sql = "SELECT IdImageProfil FROM Utilisateur where IdUtilisateur=?";
		PreparedStatement select = Data.BDD_Connection.prepareStatement(sql);
		select.setInt(1,this.getIdUser());
		ResultSet res = select.executeQuery();
		if(res.next()){
			return res.getInt(1);
		}
		else{
			return -1;
		}
	}
}
