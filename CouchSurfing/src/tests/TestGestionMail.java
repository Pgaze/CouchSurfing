package tests;
import static org.junit.Assert.assertTrue;
import modele.GestionMail;

import org.junit.Test;

public class TestGestionMail {
	
	@Test
	public void testMail (){	
		String from = "Le programme de test";
		String to = "clicknsleep@gmail.com";
		String objet = "Surprise Party";
		String text = "Viens avec nous, on va chasser des bananes !";
		
		assertTrue(GestionMail.send(from, to, objet, text));
	}
}
