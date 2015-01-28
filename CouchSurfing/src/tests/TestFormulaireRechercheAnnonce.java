package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import modele.ConnectionMySQL;
import modele.FormulaireRechercheAnnonce;
import modele.Logement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFormulaireRechercheAnnonce {
	
	private FormulaireRechercheAnnonce form;

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		this.form=null;
		ConnectionMySQL.getInstance().rollback();
	}

	@Test
	public void testLogementToulouse() throws Exception {
		this.form=new FormulaireRechercheAnnonce("Toulouse");
		List<Logement> l=this.form.getListeLogement();
		assertEquals(2,l.get(0).getIdLogement());
	}

}
