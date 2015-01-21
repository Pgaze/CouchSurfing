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
		assertEquals(3,this.dupont.getIdUser());	
	}
	
	@Test
	public void testGetUtilisateurParMail() throws Exception {
		this.dubois=Utilisateur.getUtilisateurParMail("janviermaxime@mail.com");
		assertEquals("Janvier",dubois.getName());
		assertEquals("Maxime",dubois.getFirstName());
		assertEquals("Maxime54",dubois.getPassword());
		assertEquals("Maksime",dubois.getPseudo());
	}
	

}
