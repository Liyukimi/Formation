package fr.gtm.proxibanque.dao;


import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Virement;

@Repository
public interface IVirementDao extends JpaRepository<Virement, Integer>
{
	public Collection<Virement> findAllByConseiller(Conseiller conseiller);
	public Collection<Virement> findAllByCompteDebiteur(Compte compteDebiteur);
	public Collection<Virement> findAllByCompteCrediteur(Compte compteCrediteur);
}
