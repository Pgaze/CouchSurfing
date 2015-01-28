package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import modele.ConnectionMySQL;
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
		this.utilisateur = new Utilisateur("duboispaul@mail.com","motDePasse","Dubois","Paul","Paulo");
		this.herbergeur = new Hebergeur(0563424242,"42 chemin des patates\nToulouse",2);
	}

	@After
	public void tearDown() throws Exception {
		this.utilisateur=null;
		this.herbergeur=null;
		ConnectionMySQL.getInstance().rollback();
	}

	@Test
	public void testSetIDHebergeur() {
		try {
			this.herbergeur.setIdHebergeur(this.utilisateur.createIdHebergeur());
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(2,this.herbergeur.getIdHebergeur());
	}
}