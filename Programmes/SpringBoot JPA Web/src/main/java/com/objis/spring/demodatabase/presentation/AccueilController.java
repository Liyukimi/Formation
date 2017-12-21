package com.objis.spring.demodatabase.presentation;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.objis.spring.demodatabase.service.IEmployeService;
import com.objis.spring.demodatabase.domaine.Employe;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Récupère toutes les requêtes (url-pattern ="/")
 */

@Controller
@EnableAutoConfiguration
public class AccueilController {

	private static final Logger logger = LogManager.getLogger(AccueilController.class);

	/* injection de la couche service */
	@Autowired
	private IEmployeService employeService;

	/**
	 * Renvoie vers la vue home.jsp
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.");

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	/**
	 * Envoie vers la vue listeEmploye.jsp avec la liste de tous les employes
	 */
	@RequestMapping(value = { "/listeEmployes", "employesObjis" }, method = RequestMethod.GET)
	protected ModelAndView listeEmployes(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// Récupère la liste de tous les employés
		Collection<Employe> listeEmployes = employeService.getAllEmployes();

		// Retour le modèle et la vue
		return new ModelAndView("listeEmployes", "listeEmployes", listeEmployes);
	}

	/**
	 * Envoie vers la vue detailEmploye.jsp et l'enmployé dont il récupère l'id via
	 * formulaire
	 */
	@RequestMapping(value = "/detailEmploye", method = RequestMethod.POST)
	protected ModelAndView detailEmploye(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Récupère l'info id du formulaire
		long id = 0;
		if (request.getParameter("idSelect") != null) {
			id = (long) Integer.parseInt(request.getParameter("idSelect"));
		}

		// Récupère un employé par son id
		Employe employe = employeService.getEmployeById(id);

		// Retour le modèle et la vue
		return new ModelAndView("detailEmploye", "employe", employe);
	}

}
