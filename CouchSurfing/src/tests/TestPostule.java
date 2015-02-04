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

	private Utilisateur paul;
	private Utilisateur lolo;
	private Utilisateur george;

	
	@Before
	public void setUp() throws Exception {
		Data.switchBDD_or_BDDTest(true);

		this.paul=new Utilisateur("duboispaul@mail.com","motDePasse1","Dubois","Paul","Polo");
		this.paul=Utilisateur.getUtilisateurParMail(this.paul.getMail());
		this.lolo=new Utilisateur("lolo.patate@jardin.com","motDePasse1","Lololo","Patate","LoloPatate");
		this.lolo=Utilisateur.getUtilisateurParMail(this.lolo.getMail());
		this.george=new Utilisateur("gg.le.clown@mail.com","motDePasse1","George","Clowney","GGClown");
		this.george=Utilisateur.getUtilisateurParMail(this.george.getMail());
	}

	@After
	public void tearDown() throws Exception {
		this.paul=null;
		this.lolo=null;
		Data.BDD_Connection.rollback();
	}

	@Test
	public void testPostuler() throws Exception {
		List<Offre> liste = new FormulaireRechercheAnnonce("Toulouse").getListeOffre();
		assertTrue(Postule.postulerAUneOffre(liste.get(0).getLogement().getIdLogement(),this.george.getIdUser()));
	}

	@Test
	public void testGetAllPostulationsEnCours() throws Exception {
		ArrayList<Integer> liste = Postule.getPostulationsEnCours(this.paul.getIdUser());
		assertEquals(1,liste.size());
	}
	
	@Test
	public void testDeletePostulationsPerimees() throws Exception {
		ArrayList<Integer> liste = Postule.deletePostulationsPerimees();
		assertEquals(1,liste.size());
	}	
}