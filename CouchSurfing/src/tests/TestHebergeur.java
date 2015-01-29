

package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import modele.Data;
import modele.Hebergeur;
import modele.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHebergeur {
	
	private Utilisateur utilisateur;
	private Utilisateur utilisateurHebergeur;

	private Hebergeur hebergeur;
	private Hebergeur hebergeurExistant;

	@Before
	public void setUp() throws Exception {
		this.utilisateur = Utilisateur.getUtilisateurParMail("duboispaul@mail.com");
		this.utilisateurHebergeur = Utilisateur.getUtilisateurParMail("lolo.patate@jardin.com");
		this.hebergeurExistant = Hebergeur.getHebergeurById(0);
		this.hebergeur = new Hebergeur(0563424242,"42 chemin des patates\nToulouse",2);
	}

	@After
	public void tearDown() throws Exception {
		this.utilisateur=null;
		this.hebergeur=null;
		Data.BDD_Connection.rollback();
	}
	
	@Test
	public void testCreateIDHebergeur() {
		try {
			this.hebergeur.setIdHebergeur(this.utilisateur.createIdHebergeur());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(2,this.hebergeur.getIdHebergeur());
	}
	
	@Test
	public void testCreateIDHebergeurExistant() {
		try {
			this.hebergeur.setIdHebergeur(this.utilisateurHebergeur.createIdHebergeur());
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(0,this.hebergeur.getIdHebergeur());
	}
	
	@Test
	public void testGetIdUtilisateurByIdHebergeur() {
		int idUtilisateur = -1;
		try {
			idUtilisateur = this.hebergeurExistant.getIdUtilisateurByIdHebergeur();
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(this.utilisateurHebergeur.getIdUser(),idUtilisateur);
	}
	
	@Test
	public void testDeleteHebergeur(){
		int idUtilisateur = -2;
		Hebergeur herbergeurVide = new Hebergeur();
		try {
			this.hebergeurExistant.deleteHebergeurInBDD();
			idUtilisateur = this.hebergeurExistant.getIdUtilisateurByIdHebergeur();
			herbergeurVide = Hebergeur.getHebergeurById(0);
		} catch (SQLException e) {
			e.printStackTrace();
			fail();
		}
		assertEquals(-1, this.hebergeurExistant.getIdHebergeur());
		assertEquals(null, herbergeurVide);
		assertEquals(-1, idUtilisateur);

	}
}
