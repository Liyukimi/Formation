package fr.gtm.proxibanque.service;

import java.util.Collection;

import fr.gtm.proxibanque.domaine.Compte;
import fr.gtm.proxibanque.domaine.Conseiller;
import fr.gtm.proxibanque.domaine.Virement;

public interface IVirementServices
{

	public Collection<Virement> getVirementsByCompte(Compte compte, String typeVirement);

	public Collection<Virement> getVirementsByConseiller(Conseiller conseiller);
	
	public String createVirement(Virement virement, int numCompteDebiteur, int numCompteCrediteur, double montant);
}
