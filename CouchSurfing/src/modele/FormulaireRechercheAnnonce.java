package modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FormulaireRechercheAnnonce {
	
	private String ville;

	public FormulaireRechercheAnnonce(String ville) {
		this.ville = ville;
	}
	
	/**
	 * @return liste des offres pour une ville donnée
	 * @throws Exception
	 */
	public List<Offre> getListeOffre() throws Exception {
		List<Offre> result = new ArrayList<Offre>();
		PreparedStatement s = ConnectionMySQL.getInstance().prepareStatement(
					"select Offre.IdOffre,Offre.IdLogement,Offre.IdHebergeur from Offre,Logement "
					+ "where Logement.IdLogement=Offre.IdLogement and Logement.ville=?");
		s.setString(1, this.ville);
		ResultSet rs=s.executeQuery();
		while (rs.next()){
			Logement l=Logement.getLogementById(rs.getInt(1));
			Hebergeur h=Hebergeur.getHebergeurById(rs.getInt(2));
			result.add(new Offre(rs.getInt(1),l, h, "01-01-1901", "01-01-1901"));
		}
		if (result.isEmpty()){
			throw new Exception("Aucun logement a "+this.ville);
		}
		return result;
	}
	
}
