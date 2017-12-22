package fr.gtm.demotest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.gtm.demotest.service.Calculatrice;

public class CalculatriceTest1 {

	Calculatrice maCalculatrice;

	@Before
	public void initialisation() {
		System.out.println("Donnees Test scenario ");
		maCalculatrice = new Calculatrice();
	}

	@Test
	public void monScenarioAdditionEntier() {
		System.out.println("Test scenario 1");
		long resultat = maCalculatrice.addition(2L,3L);
		assertEquals(5, resultat);
		//fail("Not yet implemented");
	}

}
