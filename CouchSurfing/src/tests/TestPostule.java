package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import modele.Data;
import modele.FormulaireRechercheAnnonce;
import modele.Offre;
import modele.Postule;
import modele.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPostule {

	private Utilisateur leblanc;
	private Utilisateur lolo;

	
	@Before
	public void setUp() throws Exception {
		Data.switchBDD_or_BDDTest(true);

		this.leblanc=new Utilisateur("herveleblanc@mail.com","motDePasse1","Leblanc","Herve","Rv");
		this.leblanc=Utilisateur.getUtilisateurParMail("herveleblanc@mail.com");
		this.lolo=new Utilisateur("lolo.patate@jardin.com","motDePasse1","LoLolo","Patate","LoloPatate");
		this.lolo=Utilisateur.getUtilisateurParMail("lolo.patate@jardin.com");
	}

	@After
	public void tearDown() throws Exception {
		this.leblanc=null;
		this.lolo=null;
		Data.BDD_Connection.rollback();
	}

	@Test
	public void testPostuler() throws Exception {
		List<Offre> liste = new FormulaireRechercheAnnonce("Paris").getListeOffre();
		assertTrue(Postule.postulerAUneOffre(liste.get(0).getIdOffre(),this.lolo.getIdUser()));
	}

	@Test
	public void testGetAllPostulationsEnCours() throws Exception {
		ArrayList<Integer> liste = Postule.getPostulationsEnCours(this.lolo.getIdUser());
		assertEquals(1,liste.size());
	}
	
	@Test
	public void testDeletePostulationsPerimees() throws Exception {
		ArrayList<Integer> liste = Postule.deletePostulationsPerimees(this.leblanc.getIdUser());
		assertEquals(1,liste.size());
	}
	
}
>>>>>>> branch 'master' of git@192.168.1.7:~/leBonRepo.git
