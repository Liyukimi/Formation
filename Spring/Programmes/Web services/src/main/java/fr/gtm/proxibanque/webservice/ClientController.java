package fr.gtm.proxibanque.webservice;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.gtm.proxibanque.dao.IClientDao;
import fr.gtm.proxibanque.domaine.Client;

@RestController
public class ClientController {

	@Autowired
	private IClientDao clientDao;

	@RequestMapping(value = "/listeClients", method = RequestMethod.GET)
	public @ResponseBody Collection<Client> getAll(/* @RequestParam(value = "login", required = true) String login */) {
		return clientDao.findByConseiller_login("Conseiller1");
	}

	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public @ResponseBody Client getByid(@RequestParam(value = "id", required = true) String id) {
		return clientDao.findByIdClient(1);
	}
}
