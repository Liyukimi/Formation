package com.objis.spring.demodatabase.presentation;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.objis.spring.demodatabase.domaine.Client;
import com.objis.spring.demodatabase.domaine.Conseiller;
import com.objis.spring.demodatabase.service.IClientServices;
import com.objis.spring.demodatabase.service.IConseillerServices;

@Controller
public class LoginController {

	@Autowired
	private IConseillerServices conseillerServices;
	
	@Autowired
	private IClientServices clientServices;
	
	@RequestMapping("/")
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/ConnexionConseiller", method = RequestMethod.POST)
	protected String connexionConseiller(HttpServletRequest request, HttpServletResponse response, Model model)
	{

		// Delete previous session info
		HttpSession oldSession = request.getSession(false);
		if (oldSession != null)
		{
			oldSession.invalidate();
		}

		// Step 1 : extract request parameters
		String loginServ = request.getParameter("login");
		String passwordServ = request.getParameter("password");

		// Step 2 : send request parameters to services package
		Conseiller conseiller = new Conseiller(loginServ, passwordServ);

		if (conseillerServices.conseillerConnection(conseiller) == true)
		{
			conseiller = conseillerServices.getConseillerByLogin(loginServ);
			if(conseiller == null)
			{
				model.addAttribute("error", "Aucun conseiller ayant pour login "+loginServ);
				return("login");
			}
			else
			{
				model.addAttribute("conseiller", conseiller);
				Collection<Client> listeClients = clientServices.getClientsByConseiller(conseiller.getLogin());
				model.addAttribute("listeClients", listeClients);
			}
			return ("index");
		}
		else
		{
			model.addAttribute("error", "Les informations de connexion fournies ne sont pas valides.");
			return("login");
		}
	}
	
	@RequestMapping(value = "/DeconnexionConseiller")
	protected String deconnexionConseiller(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		// Delete previous session info if exist
		HttpSession oldSession = request.getSession(false);
		if (oldSession != null)
		{
			oldSession.invalidate();
		}
		return("login");
	}

}