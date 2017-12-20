package com.objis.spring.demodatabase.presentation;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.objis.spring.demodatabase.service.IEmployeService;
import com.objis.spring.demodatabase.domaine.Employe;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AccueilController {
	
	private static final Logger logger = LogManager.getLogger(AccueilController.class);
	
	@Autowired
	@Qualifier("employeService")
	private IEmployeService employeService;
	
	public void setEmployeService(IEmployeService employeService) {
		this.employeService = employeService;
	}


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "accueil";
	}
	
	@RequestMapping({"/listeEmployes","employesObjis"})
	protected ModelAndView listeEmployes(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Récupère la liste de tous les employés
		Collection<Employe> listeEmployes = employeService.getAllEmployes();

		// Retour le modèle et la vue
		return new ModelAndView("accueil", "employes", listeEmployes);
	}
	
}
