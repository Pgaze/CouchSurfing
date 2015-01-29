package tests;

import modele.Data;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFormulaireConnexion.class, 
				TestFormulaireInscription.class,
				TestFormulaireProposerLogement.class,
				TestFormulaireRechercheAnnonce.class,
				TestHebergeur.class, 
				TestLogement.class,
				TestUtilisateur.class,
				MenuTest.class,
				TestPostule.class
				})
public class AllTests {
	@Before
	public void setUp() throws Exception {
		Data.switchBDD_or_BDDTest(true);
	}

	@After
	public void tearDown() throws Exception {
		Data.connection.rollback();
	}
}
