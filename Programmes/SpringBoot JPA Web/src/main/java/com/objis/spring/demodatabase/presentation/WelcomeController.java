package com.objis.spring.demodatabase.presentation;

import java.text.DateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.objis.spring.demodatabase.domaine.Employe;
import com.objis.spring.demodatabase.service.EmployeService;
import com.objis.spring.demodatabase.service.IEmployeService;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

@Controller
public class WelcomeController {

	private static final Logger logger = LogManager.getLogger(WelcomeController.class);
	
	@Autowired
	private IEmployeService employeService;

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
	 * Envoie vers la vue listeEmploye.jsp avec la liste de tous les employes
	 */
	@RequestMapping(value = {"/listeEmployes"}, method = RequestMethod.GET)
	protected String listeEmployes(Map<String, Object> model) throws Exception {

		// Récupère la liste de tous les employés
		Collection<Employe> listeEmployes = employeService.getAllEmployes();
		model.put("listeEmployes", listeEmployes);
		
		return "listeEmployes";
	}
	

}