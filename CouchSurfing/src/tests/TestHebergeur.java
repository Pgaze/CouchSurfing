package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import modele.ConnectionMySQL;
import modele.Hebergeur;
import modele.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHebergeur {
	
	private Utilisateur utilisateur;
	private Utilisateur utilisateurHebergeur;

	private Hebergeur herbergeur;

	@Before
	public void setUp() throws Exception {
		this.utilisateur = Utilisateur.getUtilisateurParMail("duboispaul@mail.com");
		this.utilisateurHebergeur = Utilisateur.getUtilisateurParMail("lolo.patate@jardin.com");

		this.herbergeur = new Hebergeur(0563424242,"42 chemin des patates\nToulouse",2);
	}

	@After
	public void tearDown() throws Exception {
		this.utilisateur=null;
		this.herbergeur=null;
		ConnectionMySQL.getInstance().rollback();
	}
	
	@Test
	public void testCreateIDHebergeur() {
		try {
			this.herbergeur.setIdHebergeur(this.utilisateur.createIdHebergeur());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(2,this.herbergeur.getIdHebergeur());
	}
	
	@Test
	public void testCreateIDHebergeurExistant() {
		try {
			this.herbergeur.setIdHebergeur(this.utilisateurHebergeur.createIdHebergeur());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(0,this.herbergeur.getIdHebergeur());
	}
}