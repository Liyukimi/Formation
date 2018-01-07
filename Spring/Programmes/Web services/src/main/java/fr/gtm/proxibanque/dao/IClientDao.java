package fr.gtm.proxibanque.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fr.gtm.proxibanque.domaine.Client;

@RepositoryRestResource
public interface IClientDao extends JpaRepository<Client, Integer> {

	public Collection<Client> findByConseiller_login(String login);

	public Client findByIdClient(int id);

	void deleteByIdClient(int id);
}
