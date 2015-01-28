package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testFormulaireConnexion.class, TestFormulaireInscription.class,
		 TestHebergeur.class, TestLogement.class,
		TestUtilisateur.class,TestFormulaireProposerLogement.class,TestFormulaireRechercheAnnonce.class })
public class AllTests {

}
