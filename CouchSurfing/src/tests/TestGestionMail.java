package tests;
import static org.junit.Assert.assertTrue;
import modele.GestionMail;

import org.junit.Test;

public class TestGestionMail {
	
	@Test
	public void testMail (String[] str){	
		String from = "Jin & Jake";
		String to = "clicknsleep@gmail.com";
		String objet = "Surprise Party";
		String text = "Viens avec nous, on va chasser des bananes !";
		
		assertTrue(new GestionMail().send(from, to, objet, text));
	}
}
