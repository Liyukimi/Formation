package com.gtm.democdi.dao;

import javax.annotation.PostConstruct;

public class ClientDao implements IClientDao {

	public String insertClient() {
		return "Creation client en base de données avec CDI";
	}
	
	@PostConstruct
	public void logApresConstruction() {
		System.out.println("Après création ClientDao");
	}

}
