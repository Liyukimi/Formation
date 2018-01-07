package fr.gtm.proxibanque.service;

import java.util.Collection;

import fr.gtm.proxibanque.domaine.Client;

public interface IClientServices
{
	public Collection<Client> getClientsByConseiller(String login);
	
	public Client getClientById(int idClient);
	
	public void updateClient(Client client);
	
	public void createClient(Client client);
	
	public void deleteClient(Client client);

	public void deleteClientById(int id);
}
