package fr.gtm.demotest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.gtm.demotest.service.Calculatrice;

public class CalculatriceTest2 {

	Calculatrice maCalculatrice;

	@Before
	public void initialisation() {
		System.out.println("Donnees Test scenario ");
		maCalculatrice = new Calculatrice();
	}


	@Test
	public void monScenario2() {
		System.out.println("Test scenario 2");
		fail("Not yet implemented");
	}

}
