package tests;

import static org.junit.Assert.*;
import modele.Data;
import modele.Offre;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestOffre {

	@Before
	public void setUp() throws Exception {
		Data.switchBDD_or_BDDTest(true);
	}

	@After
	public void tearDown() throws Exception {
		Data.BDD_Connection.rollback();
	}

	@Test
	public void getOffreByIdLogement() throws Exception {
		Offre o=Offre.getOffreByIdLogement(0);
		assertEquals(0,o.getLogement().getIdLogement());
		assertEquals(1, o.getHebergeur().getIdUser());
	}

}
