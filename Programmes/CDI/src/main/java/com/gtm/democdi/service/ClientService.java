package com.gtm.democdi.service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.gtm.democdi.dao.IClientDao;

public class ClientService implements IClientService {

	@Inject
	IClientDao dao;
	
	public String creerClient() {
		return "Service : " + dao.insertClient();
	}
	
	@PostConstruct
	public void logApresConstruction() {
		System.out.println("Après création Service");
	}

}
