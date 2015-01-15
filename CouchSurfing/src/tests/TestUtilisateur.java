package tests;

import modele.Utilisateur;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUtilisateur {

	private Utilisateur dubois;
	private Utilisateur dupont;
	
	@Before
	public void setUp() throws Exception {
		this.dubois=new Utilisateur("dubois.paul@mail.com","motDePasse","Dubois","Paul","Paulo");
		this.dupont=new Utilisateur("dupont.pierre@mail.com","motDePasse","Dupont","Pierre","Pierrot");
	}

	@After
	public void tearDown() throws Exception {
		this.dubois=null;
		this.dupont=null;
	}

	@Test
	public void testSetID() throws Exception {
		assertEquals(0,this.dubois.getIdUser());
		assertEquals(2,this.dupont.getIdUser());	
	}
	
	@Test
	public void testGetUtilisateurParMail() throws Exception {
		this.dubois=Utilisateur.getUtilisateurParMail("dubois.paul@mail.com");
		assertEquals("Dubois",dubois.getName());
		assertEquals("Paul",dubois.getFirstName());
		assertEquals("motDePasse",dubois.getPassword());
		assertEquals("Paulo",dubois.getPseudo());
	}
	

}
