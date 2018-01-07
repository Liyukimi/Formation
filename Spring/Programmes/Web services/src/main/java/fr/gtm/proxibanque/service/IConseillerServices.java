package fr.gtm.proxibanque.service;

import fr.gtm.proxibanque.domaine.Conseiller;

public interface IConseillerServices
{
	public boolean conseillerConnection(Conseiller conseiller);

	public Conseiller getConseillerByLogin(String login);
	
}
