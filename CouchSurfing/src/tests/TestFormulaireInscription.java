package tests;

import static org.junit.Assert.*;
import modele.FormulaireInscription;
import modele.Utilisateur;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFormulaireInscription {
	
	private FormulaireInscription form;
	
	@Before
	public void setUp() throws Exception {
		this.form=new FormulaireInscription();
	}
	
	@After
	public void tearDown() throws Exception {
		this.form=null;
	}
	
	@Test
	public void testInsertionBase() throws Exception {
		Utilisateur t = new Utilisateur("utilisateur@mail.com", "Md5", "Dupont", "Pierre", "Pierrot");
		assertEquals(1, this.form.insererUtilisateurDansLaBase(t));
	}

	@Test
	public void testValidationMail() {
		assertTrue(this.form.testMailValide("duboispaul@mail.com"));
		assertFalse(this.form.testMailValide("mailinvalide.com"));
	}
	
	@Test
	public void testValidationMDP() throws Exception {
		assertTrue(this.form.testMotDePasseValide("motDePasse56"));
		assertFalse(this.form.testMotDePasseValide("motdepassetoutenminuscules"));
		assertFalse(this.form.testMotDePasseValide("MOTDEPASSETOUTENMAJUSCULES"));
		assertFalse(this.form.testMotDePasseValide("court"));
		assertFalse(this.form.testMotDePasseValide("motDePasseBeaucoupBeacoupBeaucoupTropLong"));
		
	}

}
