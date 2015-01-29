package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import modele.ConnectionMySQL;
import modele.FormulaireRechercheAnnonce;
import modele.Offre;
import modele.Postule;
import modele.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPostule {

	private Utilisateur dubois;
	private Utilisateur leblanc;
	
	@Before
	public void setUp() throws Exception {
		this.dubois=new Utilisateur("duboispaul@mail.com","motDePasse","Dubois","Paul","Paulo");
		this.dubois=Utilisateur.getUtilisateurParMail("duboispaul@mail.com");
		this.leblanc=new Utilisateur("herveleblanc@mail.com","motDePasse","Leblanc","Herve","Rv");
		this.leblanc=Utilisateur.getUtilisateurParMail("herveleblanc@mail.com");
	}

	@After
	public void tearDown() throws Exception {
		this.dubois=null;
		this.leblanc=null;
		ConnectionMySQL.getInstance().rollback();
	}

	@Test
	public void testPostuler() throws Exception {
		List<Offre> liste = new FormulaireRechercheAnnonce("Toulouse").getListeOffre();
		assertTrue(Postule.postulerAUneOffre(liste.get(0).getIdOffre(),this.leblanc.getIdUser()));
	}

	@Test
	public void testGetAllPostulationsEnCours() throws Exception {
		ArrayList<Integer> liste = Postule.getPostulationsEnCours(this.dubois.getIdUser());
		assertEquals(1,liste.size());
	}
}
