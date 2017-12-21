package com.objis.spring.demodatabase.service;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objis.spring.demodatabase.dao.IEmployeDao;
import com.objis.spring.demodatabase.domaine.Employe;

@Service("employeService")
public class EmployeService implements IEmployeService {
	private static final Logger logger = LogManager.getLogger(EmployeService.class);
	/*
	 * indique que l'attribut employeDao est 'auto câblé' => va chercher selon le
	 * type de autowire (byName/byType) un bean qui correspond (ici dans la classe
	 * EmployeDao annoté par @Repository("employeDao")
	 * 
	 * Si conflit d'autowire avec byType car plusieurs impl�mentations de
	 * IEmployeDao on peut rajouter @Qualifier("idBean") où "idBean" est l'id du
	 * bean que l'on souhaite câbler
	 */
	@Autowired
	private IEmployeDao employeDao;

	public Employe getEmployeById(Long id) {
		return employeDao.findById(id);
	}

	public Employe getEmployeByLogin(String login) {
		return employeDao.findByLogin(login);
	}

	public void saveEmploye(Employe employe) {
		employeDao.save(employe);
	}

	public Long getEmployesCount() {
		return employeDao.count();
	}

	public Collection<Employe> getAllEmployes() {
		return employeDao.findAll();
	}

	@PostConstruct
	public void onInit() {
		logger.info("Bean employeDao créé");
	}

	@PreDestroy
	public void onDestroy() {
		logger.info("Bean employeDao supprimé");
	}

}
