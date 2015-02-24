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
	 * @return liste des offres pour une ville donn�e
	 * @throws Exception
	 */
	public List<Offre> getListeOffre() throws Exception {
		List<Offre> result = new ArrayList<Offre>();
		PreparedStatement s = Data.BDD_Connection.prepareStatement(
					"select Logement.IdLogement,Utilisateur.IdUtilisateur,Logement.DateDebut,Logement.DateFin from Utilisateur,Logement "
					+ "where Logement.IdLogement=Utilisateur.IdLogement and Logement.ville=?");
		s.setString(1, this.ville);
		ResultSet rs=s.executeQuery();
		while (rs.next()){
			Logement l=Logement.getLogementById(rs.getInt(1));
			Utilisateur u=Utilisateur.getUtilisateurById(rs.getInt(2));
			result.add(new Offre(l, u, rs.getString(3), rs.getString(4)));
		}
		if (result.isEmpty()){
			throw new Exception("Aucun logement a "+this.ville);
		}
		return result;
	}
	
}
