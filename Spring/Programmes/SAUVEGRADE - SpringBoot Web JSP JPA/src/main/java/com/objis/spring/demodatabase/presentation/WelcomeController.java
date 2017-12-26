package com.objis.spring.demodatabase.presentation;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.objis.spring.demodatabase.domaine.Employe;
import com.objis.spring.demodatabase.service.IEmployeService;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

@Controller
public class WelcomeController {

	private static final Logger logger = LogManager.getLogger(WelcomeController.class);
	
	@Autowired
	private IEmployeService employeService;

	/**
	 * La page d'accueil ("/")
	 * @param locale (pour l'affichage de la date/heure)
	 * @param model
	 * @return le nom logique de la vue : home 
	 * (va chercher dans applications.properties l'emplacement et le suffixe de la page correspondante)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is "+locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
	/**
	 * Exemple pour la page welcome.jsp qui prend en compte un css 
	 * (dans src/main/resources/static) 
	 * @param model
	 * @return le nom logique de la vue : welcome
	 */
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("message", "Il etait un petit navireuhhhhhh !!!");
		return "welcome";
	}
	
	/**
	 * Envoie vers la vue listeEmploye.jsp avec la liste de tous les employes
	 * 
	 * @param model
	 * @return exemple où on ne renvoie que le nom logique de la vue sous forme de String
	 * @throws Exception
	 */
	@RequestMapping(value = {"/listeEmployes"}, method = RequestMethod.GET)
	protected String listeEmployes(Model model) throws Exception {

		// Récupère la liste de tous les employés
		Collection<Employe> listeEmployes = employeService.getAllEmployes();
		model.addAttribute("listeEmployes", listeEmployes);
		
		return "listeEmployes";
	}
	
	/**
	 * Envoie vers la vue detailEmploye.jsp et l'enmployé dont il récupère l'id via
	 * formulaire
	 * @param request
	 * @param response
	 * @return Exemple qui retourne le modèle ET la vue
	 * @throws Exception
	 */
	@RequestMapping(value = "/detailEmploye", method = RequestMethod.POST)
	protected ModelAndView detailEmploye(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Récupère l'info id du formulaire
		long id = (long) Integer.parseInt(request.getParameter("idSelect"));

		// Récupère un employé par son id
		Employe employe = employeService.getEmployeById(id);

		// Retour le modèle et la vue
		return new ModelAndView("detailEmploye", "employe", employe);
	}
	

}