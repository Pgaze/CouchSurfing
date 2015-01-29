package tests;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import modele.Data;
import modele.FormulaireConnexion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFormulaireConnexion {
	
	FormulaireConnexion form;

	@Before
	public void setUp() throws Exception {
		this.form=new FormulaireConnexion();
	}

	@After
	public void tearDown() throws Exception {
		this.form=null;
		Data.connection.rollback();
	}

	@Test
	public void testTrue() throws SQLException {
		this.form.setLogin("duboispaul@mail.com");
		this.form.setMdp("motDePasse1");
		assertTrue(this.form.verificationCoupleMailMotDePasse());
	}

}
