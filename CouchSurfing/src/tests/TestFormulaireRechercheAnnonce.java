package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import modele.Data;
import modele.FormulaireRechercheAnnonce;
import modele.Offre;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFormulaireRechercheAnnonce {
	
	private FormulaireRechercheAnnonce form;

	@Before
	public void setUp() throws Exception {
		Data.switchBDD_or_BDDTest(true);
	}

	@After
	public void tearDown() throws Exception {
		this.form=null;
		Data.BDD_Connection.rollback();
	}

	@Test
	public void testLogementToulouse() throws Exception {
		this.form=new FormulaireRechercheAnnonce("Toulouse");
		List<Offre> l = this.form.getListeOffre();
		assertEquals(0,l.get(0).getLogement().getIdLogement());
	}
	
	@Test(expected = Exception.class)
	public void testLogementInconnu() throws Exception {
		this.form=new FormulaireRechercheAnnonce("Albi");
		this.form.getListeOffre();
	}
}