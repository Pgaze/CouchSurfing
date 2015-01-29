package tests;

import static org.junit.Assert.*;

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
	private Utilisateur dupont;
	
	@Before
	public void setUp() throws Exception {
		this.dubois=new Utilisateur("duboispaul@mail.com","motDePasse","Dubois","Paul","Paulo");
		this.dupont=new Utilisateur("dupont.pierre@mail.com","motDePasse","Dupont","Pierre","Pierrot");
	}

	@After
	public void tearDown() throws Exception {
		this.dubois=null;
		this.dupont=null;
		ConnectionMySQL.getInstance().rollback();
	}

	@Test
	public void testPostuler() throws Exception {
		this.dubois=Utilisateur.getUtilisateurParMail("duboispaul@mail.com");
		List<Offre> l = new FormulaireRechercheAnnonce("Toulouse").getListeOffre();
		assertTrue(Postule.postulerAUneOffre(l.get(0).getIdOffre(),this.dubois.getIdUser()));
	}

	@Test
	public void testGetAllPostulationsEnCours() throws Exception {
		this.dubois=Utilisateur.getUtilisateurParMail("duboispaul@mail.com");
		ArrayList<Integer> liste = Postule.getPostulationsEnCours(this.dubois.getIdUser());
		assertEquals(1,liste.size());
	}
}
