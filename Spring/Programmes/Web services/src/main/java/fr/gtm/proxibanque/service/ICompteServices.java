package fr.gtm.proxibanque.service;

import java.util.Collection;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;

public interface ICompteServices
{
	public Collection<Compte> getCompteByClient(Client client);
	public Compte getCompteByNumero(int numeroCompte);

	public Collection<Compte> getAllComptes();

	public Collection<Compte> getComptesByConseiller(Conseiller conseiller);
}
