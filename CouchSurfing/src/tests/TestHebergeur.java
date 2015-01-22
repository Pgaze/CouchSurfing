package tests;

import static org.junit.Assert.fail;
import modele.Hebergeur;
import modele.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHebergeur {
	
	private Utilisateur utilisateur;
	private Hebergeur herbergeur;

	@Before
	public void setUp() throws Exception {
		this.utilisateur=new Utilisateur("duboispaul@mail.com","motDePasse","Dubois","Paul","Paulo");
		this.herbergeur=new Hebergeur(0563424242,"42 chemin des patates\nToulouse",2);
		this.herbergeur.setIdHebergeur(this.utilisateur.createIdHebergeur());
	}

	@After
	public void tearDown() throws Exception {
		this.utilisateur.setIdHebergeur(0);
		this.herbergeur.deleteHebergeurInBDD();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}