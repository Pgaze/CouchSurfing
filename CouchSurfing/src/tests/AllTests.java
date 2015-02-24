package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestConnnexionBDD.class,
				TestFormulaireConnexion.class, 
				TestFormulaireInscription.class,
				TestFormulaireProposerLogement.class,
				TestFormulaireRechercheAnnonce.class,
				TestLogement.class,
				TestUtilisateur.class,
				MenuTest.class,
				TestPostule.class,
				TestImage.class,
				TestCritereLogement.class
				})
public class AllTests {

}
