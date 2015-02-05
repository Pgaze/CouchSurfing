package tests;

import static org.junit.Assert.assertEquals;
import modele.ConnectionMySQL;
import modele.Data;
import modele.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUtilisateur {

	private Utilisateur dubois;
	private Utilisateur dupont;
	
	@Before
	public void setUp() throws Exception {
		ConnectionMySQL.switchBDD_or_BDDTest(true);

		this.dubois=new Utilisateur("duboispaul@mail.com","motDePasse","Dubois","Paul","Paulo");
		this.dupont=new Utilisateur("dupont.pierre@mail.com","motDePasse","Dupont","Pierre","Pierrot");
	}

	@After
	public void tearDown() throws Exception {
		this.dubois=null;
		this.dupont=null;
		Data.BDD_Connection.rollback();
	}

	@Test
	public void testSetID() throws Exception {
		assertEquals(0,this.dubois.getIdUser());
		assertEquals(3,this.dupont.getIdUser());	
	}
	
	@Test
	public void testGetUtilisateurParMail() throws Exception {
		this.dubois=Utilisateur.getUtilisateurParMail("duboispaul@mail.com");
		assertEquals("Dubois",dubois.getName());
		assertEquals("Paul",dubois.getFirstName());
		assertEquals("motDePasse1",dubois.getPassword());
		assertEquals("Paulo",dubois.getPseudo());
	}
	
	@Test
	public void testGetUtilisateurById() throws Exception {
		this.dubois=Utilisateur.getUtilisateurById(0);
		assertEquals("Dubois",dubois.getName());
	}
	
	@Test
	public void testUpdConfiance() throws Exception {
		this.dubois=Utilisateur.getUtilisateurById(0);
		assertEquals(0,this.dubois.getAvgConfiance());
		this.dubois.voteConfiance(5);
		this.dubois.updateConfiance();
		assertEquals(5,this.dubois.getAvgConfiance());
	}
	
	@Test
	public void testUpdtConfort() throws Exception {
		this.dubois=Utilisateur.getUtilisateurById(0);
		assertEquals(0,this.dubois.getAvgConfort());
		this.dubois.voteConfort(3);
		this.dubois.updateConfort();
		assertEquals(3,this.dubois.getAvgConfort());
	}
	
	
}
