package tests;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import modele.ConnectionMySQL;
import modele.Data;
import modele.Offre;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestOffre {

	private Offre offre;
	
	@Before
	public void setUp() throws Exception {
		ConnectionMySQL.switchBDD_or_BDDTest(true);
		offre = Offre.getOffreByIdLogement(0);
	}

	@After
	public void tearDown() throws Exception {
		offre = null;
		Data.BDD_Connection.rollback();
	}

	@Test
	public void getOffreByIdLogement() throws Exception {
		Offre o=Offre.getOffreByIdLogement(0);
		assertEquals(0, o.getLogement().getIdLogement());
		assertEquals(1, o.getHebergeur().getIdUser());
	}
	
	@Test
	public void constructeurDateValide() throws Exception {
		Offre o = new Offre(offre.getLogement(), offre.getHebergeur(), "2015-06-01", "2015-07-01");
		assertEquals("2015-06-01", o.getDateDebut());
	}
	
	@Test
	public void constructeurDateInvalideFormat() throws Exception {
		Offre o = new Offre(offre.getLogement(), offre.getHebergeur(), "2015/06-01", "2015/06-01");
		assertEquals(null,o.getDateDebut());
		assertEquals(null,o.getDateFin());
		Offre o1 = new Offre(offre.getLogement(), offre.getHebergeur(), "2015/06/01", "2015/06/01");
		assertEquals(null,o1.getDateDebut());
		assertEquals(null,o1.getDateFin());
		Offre o2 = new Offre(offre.getLogement(), offre.getHebergeur(), "06-01-2015", "06-01-2015");
		assertEquals(null,o2.getDateDebut());
		assertEquals(null,o2.getDateFin());
	}
	
	@Test
	public void constructeurDateInvalideFinAvantDebut() throws Exception {
		Offre o = new Offre(offre.getLogement(), offre.getHebergeur(), "2015-07-01", "2015-06-01");
		assertEquals(null,o.getDateDebut());
		assertEquals(null,o.getDateFin());
	}
	
	@Test
	public void constructeurDateInvalideDebutAvantAjd() throws Exception {
		Date d = new Date(System.currentTimeMillis());
		Offre o = new Offre(offre.getLogement(), offre.getHebergeur(), Offre.creerStringDate(d.getYear(), d.getMonth(), d.getDay()), "2015-07-01");
		assertEquals(null,o.getDateDebut());
		assertEquals(null,o.getDateFin());
	}
}
