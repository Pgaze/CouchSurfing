package tests;

import static org.junit.Assert.assertEquals;
import modele.Adresse;
import modele.Data;
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
		Data.connection.rollback();
	}

	@Test
	public void testSetIDExistant() throws Exception {
		Logement l1= new Logement(new Adresse("1", "35 Avenue Rangueil", "31400","Les Pigeons", "0", "Toulouse"));
		assertEquals(2,l1.getIdLogement());
	}
	
	@Test
	public void testSetIdNonExistant() throws Exception {
		Logement l2= new Logement(new Adresse("10", "35 Rue Rangueil", "31400","Les oies", "0", "Toulouse"));
		assertEquals(5,l2.getIdLogement());
	}

}
