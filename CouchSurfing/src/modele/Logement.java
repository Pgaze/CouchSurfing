package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Logement {
	
	private int idLogement;
	private Adresse adresse;
	
	public Logement(Adresse adresse) throws SQLException {
		super();
		this.adresse = adresse;
		this.setId();
	}
	
	public Logement() {
	}

	private void setId() throws SQLException {
		Connection c=ConnectionMySQL.getInstance();
		PreparedStatement select=c.prepareStatement("select IdLogement from Logement where"
				+ " batimentEscalier=? and numeroEtVoie=? and cp=? and residence=? "
				+ "and complementAdresse=? and ville=?");
		select.setString(1, this.adresse.getBatimentEscalier());
		select.setString(2,this.adresse.getNumeroEtVoie());
		select.setString(3, this.adresse.getCp());
		select.setString(4, this.adresse.getResidence());
		select.setString(5, this.adresse.getComplementAdresse());
		select.setString(6,this.adresse.getVille());
		ResultSet resultSelect=select.executeQuery();
		if(resultSelect.next()){
			this.idLogement=resultSelect.getInt(1);
		}
		else{	
			Statement count=c.createStatement();
			ResultSet resultCount=count.executeQuery("select count(IdLogement) from Logement ");
			resultCount.next();
			this.idLogement=resultCount.getInt(1)+1;

		}

	}

	public boolean insererDansLaBase() throws SQLException{
		PreparedStatement insert= ConnectionMySQL.getInstance().prepareStatement(""
				+ "insert into Logement (idLogement,batimentEscalier,numeroEtVoie,cp,residence,complementAdresse,ville)"
				+ "values (?,?,?,?,?,?,?)");
		insert.setInt(1, this.idLogement);
		insert.setString(2, this.adresse.getBatimentEscalier());
		insert.setString(3,this.adresse.getNumeroEtVoie());
		insert.setString(4, this.adresse.getCp());
		insert.setString(5, this.adresse.getResidence());
		insert.setString(6, this.adresse.getComplementAdresse());
		insert.setString(7,this.adresse.getVille());
		int res=insert.executeUpdate();
		if (res==1){
			return true;
		}
		return false;
	}

	public int getIdLogement() {
		return idLogement;
	}

	public void setIdLogement(int idLogement) {
		this.idLogement = idLogement;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	
	
}
