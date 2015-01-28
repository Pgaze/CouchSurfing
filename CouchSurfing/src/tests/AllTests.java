package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testFormulaireConnexion.class, TestFormulaireInscription.class,
		TestGestionMail.class, TestHebergeur.class, TestLogement.class,
		TestUtilisateur.class,TestFormulaireProposerLogement.class })
public class AllTests {

}
