package fr.gtm.proxibanque.dao;


import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.gtm.proxibanque.domaine.Client;
import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;

public interface ICompteDao extends JpaRepository<Compte, Integer>
{
	public Collection<Compte> findByClient(Client client);
	public Compte findByNumeroCompte(int numeroCompte);
	public List<Compte> findAll();
	public List<Compte> findAllByClient_Conseiller(Conseiller conseiller);
}
