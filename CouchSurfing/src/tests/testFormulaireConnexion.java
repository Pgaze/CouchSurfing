package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import modele.FormulaireConnexion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testFormulaireConnexion {
	
	FormulaireConnexion form;

	@Before
	public void setUp() throws Exception {
		this.form=new FormulaireConnexion();
	}

	@After
	public void tearDown() throws Exception {
		this.form=null;
	}

	@Test
	public void testTrue() throws SQLException {
		assertTrue(this.form.verificationCoupleMailMotDePasse("dubois.paul@mail.com", "motDePasse"));
	}

}
