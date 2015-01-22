package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import modele.Adresse;
import modele.ConnectionMySQL;
import modele.Logement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestLogement {

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		ConnectionMySQL.getInstance().rollback();
	}

	@Test
	public void testSetID() throws Exception {
		Logement l1= new Logement(new Adresse("1", "35 Avenue Rangueil", "31400","Les Pigeons", "0", "Toulouse"));
		Logement l2= new Logement(new Adresse("10", "35 RueRangueil", "31400","Les oies", "0", "Toulouse"));
		assertEquals(0,l1.getIdLogement());
		assertEquals(1,l2.getIdLogement());	
	}

}
