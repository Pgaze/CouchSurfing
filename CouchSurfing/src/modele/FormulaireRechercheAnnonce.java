package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormulaireRechercheAnnonce {
	
	private String ville;

	public FormulaireRechercheAnnonce(String ville) {
		super();
		this.ville = ville;
	}
	
	public List<Logement> getListeLogement() throws Exception{
		List<Logement> result = new ArrayList<Logement>();
		PreparedStatement s = ConnectionMySQL.getInstance().prepareStatement("select batimentEscalier,complementAdresse,cp,numeroEtVoie,residence,ville from Logement where ville=?");
		s.setString(1, this.ville);
		ResultSet rs=s.executeQuery();
		while (rs.next()){
			String batimentEscalier = rs.getString(1);
			String complementAdresse = rs.getString(2);
			String cp = rs.getString(3);
			String numeroEtVoie = rs.getString(4);
			String residence = rs.getString(5);
			String ville = rs.getString(6);
			Adresse a = new Adresse(batimentEscalier, numeroEtVoie, cp, residence, complementAdresse, ville);
			result.add(new Logement(a));
		}
		if (result.isEmpty()){
			throw new Exception("Aucun logement dans cette ville");
		}
		return result;
	}
	
}
